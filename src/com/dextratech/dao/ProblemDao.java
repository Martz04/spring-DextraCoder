package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Problem;
import com.dextratech.dto.User;

public interface ProblemDao {

	public List<Problem> getAllProblems();
	public Problem getProblem(int problemId);
	public void saveNewProblem(Problem problem);
	public void updateProblem(Problem problem);
	public void deleteProblem(Problem problem);
}
