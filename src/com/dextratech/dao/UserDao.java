package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Roles;
import com.dextratech.dto.User;

public interface UserDao {

	public User getUserById(int id);
	public User getUserByName(String name);
	public List<Roles> getRolesByUserId(int userId);
	public void saveNewUser(UserDao user);
	public void deleteUser(UserDao user);
	public void updateUser(UserDao user);
}
