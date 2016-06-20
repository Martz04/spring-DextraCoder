package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Problem;
import com.dextratech.dto.Roles;

public interface User {

	public List<Roles> getRolesByUserId(int userId);
	public void saveNewUser(User user);
	public void deleteUser(User user);
	public void resetPasswordForUser(User user);
}
