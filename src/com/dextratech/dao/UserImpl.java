package com.dextratech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dextratech.dto.Rol;
import com.dextratech.dto.User;

@Transactional
@Repository
public class UserImpl implements UserDao {

	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
		
	@Override
	public User getUserById(int id) {
		return (User) getSession().createCriteria(User.class).add(Restrictions.eq("userId", id)).uniqueResult();
	}

	
	@Override
	public User getUserByName(String name) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> getRolesByUserId(int userId) {
		
		return getSession().createQuery("from Roles r where r.userId = :userId")
				.setParameter("userId", userId).list();
	}

	@Override
	public void saveNewUser(User user) {
		getSession().saveOrUpdate(user);

	}

	@Override
	public void deleteUser(User user) {
		getSession().delete(user);
	}

	@Override
	public void updateUser(User user) {
		getSession().update(user);
	}

}
