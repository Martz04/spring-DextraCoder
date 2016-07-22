package com.dextratech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextratech.dao.ProblemDao;
import com.dextratech.dao.SolvedProblemDao;
import com.dextratech.dao.UserDao;
import com.dextratech.dto.Problem;
import com.dextratech.dto.ProblemWithSolutionDTO;
import com.dextratech.dto.SolvedProblem;
import com.dextratech.dto.User;

@Service
public class SolutionService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private SolvedProblemDao solvedDao;
	@Autowired
	private ProblemDao problemDao;
	
	public List<ProblemWithSolutionDTO> listAllProblemsForUserName(String name) {
		List<ProblemWithSolutionDTO> list = new ArrayList<>();
		ProblemWithSolutionDTO dto = new ProblemWithSolutionDTO();
		User user = userDao.getUserByName(name);
		List<SolvedProblem> problemsSolved = solvedDao.getSolvedProblemsForUser(user);
		for(SolvedProblem solution : problemsSolved) {
			dto.setSolution(solution.getSolution());
			dto.setElapsedTime(solution.getElapsedTime());
			Problem problem = solution.getProblem();
			dto.setTitle(problem.getTitle());
			dto.setDescription(problem.getDescription());
			dto.setInputDescription(problem.getInputDescription());
			dto.setOutputDescription(problem.getOutputDescription());
			dto.setProblemId(problem.getProblemId());
			
			list.add(dto);
			dto = new ProblemWithSolutionDTO();
		}
		return list;
	}
}
