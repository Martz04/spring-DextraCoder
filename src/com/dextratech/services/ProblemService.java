package com.dextratech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextratech.dao.ProblemDao;
import com.dextratech.dto.Problem;

@Service
public class ProblemService {

	@Autowired
	private ProblemDao problemDao;
	
	public Problem getRandomProblem(){
		return problemDao.getProblem(1);
	}
	public void save(Problem problem) {
		problemDao.saveNewProblem(problem);
	}

}
