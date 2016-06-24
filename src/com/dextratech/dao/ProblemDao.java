package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Problem;

public interface ProblemDao {

	public Problem getMostResolvedProblem();
	public Problem getLeastResolvedProblem();
	public List<Problem> getAllProblems();
	public Problem getProblem(int problemId);
	public void saveNewProblem(Problem problem);
	public void updateProblem(Problem problem);
	public void deleteProblem(Problem problem);
}
