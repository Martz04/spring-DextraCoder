package com.dextratech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dextratech.dao.UserDao;
import com.dextratech.dto.Roles;
import com.dextratech.dto.User;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserbyId(int id){
		return userDao.getUserById(id);
	}
	
	public org.springframework.security.core.userdetails.User getSecurityUserByName(String name) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		User user = userDao.getUserByName(name);
		if(user != null) {
			for(Roles role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getDescription()));
			}
			org.springframework.security.core.userdetails.User springUser = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
			return springUser;
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}
}
