package com.dextratech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dextratech.dto.Problem;
import com.dextratech.dto.SolvedProblem;

public class SolvedProblemImpl implements SolvedProblemDao {
	
	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public void setSolvedProblem(SolvedProblem solution) {
		getSession().persist(solution);
	}


	@Override
	public List<Problem> getSolvedProblemsByUserId(int userId) {
		Criteria crit = getSession().createCriteria(SolvedProblem.class);
		
		return null;
	}

	@Override
	public List<Problem> getUnsolvedProblemsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
