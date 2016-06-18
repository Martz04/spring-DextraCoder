package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.ProblemInputOutput;

public interface ProblemSolutionDao {

	public List<ProblemInputOutput> getSolutionsForProblemId(int problemId);
}
