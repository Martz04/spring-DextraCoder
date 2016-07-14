package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Problem;
import com.dextratech.dto.SolvedProblem;
import com.dextratech.dto.User;

public interface SolvedProblemDao {

	public List<User> getUsersSolvedProblem(Problem problem);
	public List<SolvedProblem> getSolvedProblemsForUser(User user);
	public List<Problem> getUnsolvedProblemsForUser(User user);
	public void setSolvedProblem(SolvedProblem solution);

}
