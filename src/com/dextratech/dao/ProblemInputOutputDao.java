package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Problem;
import com.dextratech.dto.ProblemInputOutput;

public interface ProblemInputOutputDao {

	public List<ProblemInputOutput> getInputsForProblemId(int problemId);
	public void addInputOutputToProblem(Problem problem, ProblemInputOutput input);
	public void deleteInputOutputForProblem(ProblemInputOutput input);
	public void editInputOutputForProblem(ProblemInputOutput input);
}
