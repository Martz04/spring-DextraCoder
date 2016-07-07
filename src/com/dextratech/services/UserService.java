package com.dextratech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextratech.dao.UserDao;
import com.dextratech.dto.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserbyId(int id){
		return userDao.getUserById(id);
	}
}
