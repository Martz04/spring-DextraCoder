package com.dextratech.dao;

import java.util.List;

import com.dextratech.dto.Rol;
import com.dextratech.dto.User;

public interface UserDao {

	public User getUserById(int id);
	public User getUserByName(String name);
	public List<Rol> getRolesByUserId(int userId);
	public void saveNewUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
}
