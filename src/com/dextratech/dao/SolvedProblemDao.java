package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Problem;
import com.dextratech.dto.SolvedProblem;

public interface SolvedProblemDao {

	public List<Problem> getSolvedProblemsByUserId(int userId);
	public List<Problem> getUnsolvedProblemsByUserId(int userId);
	public void setSolvedProblem(SolvedProblem solution);

}
