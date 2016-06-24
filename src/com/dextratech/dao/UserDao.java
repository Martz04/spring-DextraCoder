package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Problem;
import com.dextratech.dto.Roles;

public interface UserDao {

	public List<Roles> getRolesByUserId(int userId);
	public void saveNewUser(UserDao user);
	public void deleteUser(UserDao user);
	public void updateUser(UserDao user);
}
