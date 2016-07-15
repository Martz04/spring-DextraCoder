package com.dextratech.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextratech.dao.ProblemDao;
import com.dextratech.dao.SolvedProblemDao;
import com.dextratech.dto.Problem;
import com.dextratech.dto.ProblemInputOutput;
import com.dextratech.dto.ProblemParametersDTO;
import com.dextratech.dto.User;
import com.dextratech.utils.ParameterUtils;


@Service
public class ProblemService {

	@Autowired
	private ProblemDao problemDao;
	@Autowired
	private SolvedProblemDao solvedDao;
	
	public ProblemParametersDTO getRandomProblemForUser(User user){
		ProblemParametersDTO dto = new ProblemParametersDTO();
		List<Problem> unsolvedProblemsForUser = solvedDao.getUnsolvedProblemsForUser(user);
		Random random = new Random();
		int randomInt = random.nextInt(unsolvedProblemsForUser.size());
		Problem problem = unsolvedProblemsForUser.get(randomInt);
		problem.setUserProblem(null);
		for(ProblemInputOutput inputs : problem.getProblemInputOutputs()) {
			inputs.setProblem(null);
		}
		dto.setProblem(problem);
		dto.setInputParams(ParameterUtils.getParameterFromText(problem.getInputDescription()) + " " + "args");
		dto.setOutputParams(ParameterUtils.getParameterFromText(problem.getOutputDescription()));
		return dto;
	}
	
	public void save(Problem problem) {
		problemDao.saveNewProblem(problem);
	}

	
}
