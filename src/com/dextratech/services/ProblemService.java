package com.dextratech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextratech.dao.ProblemDao;
import com.dextratech.dto.Problem;
import com.dextratech.dto.ProblemParametersDTO;
import com.dextratech.utils.ParameterUtils;


@Service
public class ProblemService {

	@Autowired
	private ProblemDao problemDao;
	
	public ProblemParametersDTO getRandomProblem(){
		ProblemParametersDTO dto = new ProblemParametersDTO();
		Problem problem = problemDao.getProblem(1);
		dto.setProblem(problem);
		dto.setInputParams(ParameterUtils.getParameterFromText(problem.getInputDescription()));
		dto.setOutputParams(ParameterUtils.getParameterFromText(problem.getOutputDescription()));
		return dto;
	}
	
	public void save(Problem problem) {
		problemDao.saveNewProblem(problem);
	}

	
}
