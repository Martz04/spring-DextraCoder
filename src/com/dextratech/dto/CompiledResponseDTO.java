package com.dextratech.dto;

import java.util.List;

public class CompiledResponseDTO {

	private int compilationStatus;
	private String output;
	private List<OutputSolutionDTO> solutions;
	private boolean finish;
	
	
	public int getCompilationStatus() {
		return compilationStatus;
	}
	public void setCompilationStatus(int compilationStatus) {
		this.compilationStatus = compilationStatus;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public List<OutputSolutionDTO> getSolutions() {
		return solutions;
	}
	public void setSolutions(List<OutputSolutionDTO> solutions) {
		this.solutions = solutions;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
	
}
