package com.dextratech.services;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.dextratech.dao.ProblemDao;
import com.dextratech.dto.CompiledResponseDTO;
import com.dextratech.dto.OutputSolutionDTO;
import com.dextratech.dto.Problem;
import com.dextratech.dto.ProblemInputOutput;
import com.dextratech.dto.UserSolutionDTO;
import com.dextratech.utils.ParameterUtils;

@Service
public class CodeService implements ResourceLoaderAware{

	private static final String CLASS_NAME = "DextraCoder";
	private static final String JAVA_SOURCE_EXTENSION = ".java";
	private static final String JAVA_CLASS_EXTENSION = ".class";
	private static final int COMPILATION_SUCCESS = 0;
	private static final int COMPILATION_ERROR = 1;
	
	private Path sourceFilePath;
	private ResourceLoader resourceLoader;
	private Problem problem;
	
	@Autowired
	private ProblemDao problemDao;
	
	public CompiledResponseDTO executeSolutionForProblem(UserSolutionDTO solution, String realPath) {
		CompiledResponseDTO codeDTO = new CompiledResponseDTO();
		problem = problemDao.getProblem(solution.getProblemId());
		try {
			createSourceFileWithPath(realPath);
			writeSolutionToFile(solution.getAnswer());
			ByteArrayOutputStream compilationError = compileSourceCode();
			if(compilationError == null) {
				codeDTO.setCompilationStatus(COMPILATION_SUCCESS);
				List<ProblemInputOutput> inputs = problem.getProblemInputOutputs();
				codeDTO.setSolutions(createOutputSolutionForInputList(inputs)); 
			} else {
				codeDTO.setCompilationStatus(COMPILATION_ERROR);
				codeDTO.setOutput(formatError(compilationError.toString()));
			}
		} catch (IOException e) {
			codeDTO.setOutput(e.getMessage());
		}
		
		return codeDTO;
	}
	
	private String formatError(String string) {
		String error = string.substring(string.lastIndexOf(":") + 1);
		return error;
	}

	private void createSourceFileWithPath(String path) throws IOException {
		Path root = Paths.get(path);
		sourceFilePath = Paths.get(root.toString(), CLASS_NAME + JAVA_SOURCE_EXTENSION);		
		if(Files.exists(sourceFilePath, LinkOption.NOFOLLOW_LINKS)) {
			Files.delete(sourceFilePath);
		}
		Files.createFile(sourceFilePath);
	}
	
	private void writeSolutionToFile(String solution) throws FileNotFoundException, IOException {
		PrintWriter dextraWritter = new PrintWriter(sourceFilePath.toFile());
		StringBuffer buffer = getCodeTemplate();
		String typeToUse = getCorrectTypeFromArguments();
		buffer.append(typeToUse);
		buffer.append("}\n");
		buffer.append("\t" + solution);
		buffer.append("}\n");
		dextraWritter.write(buffer.toString());
		dextraWritter.flush();
		dextraWritter.close();
	}
	
	private String getCorrectTypeFromArguments() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:com/dextratech/resources/ValueTypes.properties");
		Properties properties = new Properties();
		properties.load(resource.getInputStream());
		String key  = ParameterUtils.getValueTypeKey(problem.getInputDescription());
		return properties.getProperty(key);
	}

	private ByteArrayOutputStream compileSourceCode() {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayOutputStream err = new ByteArrayOutputStream();
		int result = compiler.run(null, out, err, sourceFilePath.toFile().getPath());
		if(result == COMPILATION_SUCCESS) {
			return null;
		}else {
			return err;
		}
	}
	
	private List<OutputSolutionDTO> createOutputSolutionForInputList(List<ProblemInputOutput> inputs) throws IOException{
		List<OutputSolutionDTO> solutions = new ArrayList<>();
		for (ProblemInputOutput input : inputs) {
			OutputSolutionDTO s = executeProgramForInput(input);
			solutions.add(s);
			if(s.isPassed() == false) {
				break;
			}
		}
		
		return solutions;	
	}

	private OutputSolutionDTO executeProgramForInput(ProblemInputOutput input) throws IOException{
		try {
			OutputSolutionDTO output = new OutputSolutionDTO();
			output.setInputId(input.getProblemInputOutputId());

			StringBuilder cmdBuilder = new StringBuilder();
			cmdBuilder.append("java -cp");
			cmdBuilder.append(" ");
			cmdBuilder.append(sourceFilePath.getParent().toAbsolutePath().toString());
			cmdBuilder.append(" ");
			cmdBuilder.append(CLASS_NAME);
			//Get Input parameter type
			cmdBuilder.append(" ");
			cmdBuilder.append(ParameterUtils.getParameterFromText(problem.getDescription()));
			if(input.getInput() != null && input.getInput().length() > 0) {
				cmdBuilder.append(" ");
				cmdBuilder.append(input.getInput().replace("[", "").replace("]", "").replace(",", ""));
			}
			Process p = Runtime.getRuntime().exec(cmdBuilder.toString());
			BufferedReader in = new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			BufferedReader errorStream = new BufferedReader(
					new InputStreamReader(p.getErrorStream()));
			String line = null;
			StringBuilder builder = new StringBuilder();
			while ((line = in.readLine()) != null) {
				builder.append(line);
			}
			if(builder.length() == 0){
				while ((line = errorStream.readLine()) != null) {
					builder.append(line);
				}
				output.setPassed(false);
				output.setDetail(builder.toString());
			}else {
				if(input.getOutput().equals(builder.toString())) {
					output.setPassed(true);
				}
				output.setDetail(builder.toString());
			}
			return output;
		}catch (IOException e) {
			throw new IOException("Failed to run program.", e); 
		}
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		
	}
	
	public StringBuffer getCodeTemplate() throws IOException{
		Resource resource = resourceLoader.getResource("classpath:com/dextratech/resources/codeTemplate.txt");
		try(	InputStreamReader input = new InputStreamReader(resource.getInputStream());
				BufferedReader br = new BufferedReader(input)) {
			StringBuffer buffer = new StringBuffer();
			
			String line = br.readLine();
			while(line != null) {
				buffer.append(line);
				buffer.append("\n");
				line = br.readLine();
			}
			return buffer;
		}catch(IOException e) {
			throw new IOException("Error loading template", e);
		}
	}
}
