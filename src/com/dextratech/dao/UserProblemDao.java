package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Problem;

public interface UserProblemDao {

	public List<Problem> getResolvedProblemsByUserId(int userId);
	public List<Problem> getUnsolvedProblemsByUserId(int userId);

}
