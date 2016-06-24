package com.dextratech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dextratech.dto.Roles;

@Transactional
@Repository
public class UserImpl implements UserDao {

	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getRolesByUserId(int userId) {
		
		return getSession().createQuery("from Roles r where r.userId = :userId")
				.setParameter("userId", userId).list();
	}

	@Override
	public void saveNewUser(UserDao user) {
		getSession().save(user);

	}

	@Override
	public void deleteUser(UserDao user) {
		getSession().delete(user);
	}

	@Override
	public void updateUser(UserDao user) {
		getSession().update(user);
	}

}
