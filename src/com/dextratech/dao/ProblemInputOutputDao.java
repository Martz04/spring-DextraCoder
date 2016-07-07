package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.ProblemInputOutput;

public interface ProblemInputOutputDao {

	public List<ProblemInputOutput> getInputsOutputsForProblemId(int problemId);
	
	public void addInputOutputToProblemId(int problemId);
	public void deleteInputOutputForProblemId(int problemId);
	public void editInputOutputForProblemId(int problemId);
}
