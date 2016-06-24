package com.dextratech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dextratech.dto.Problem;
import com.dextratech.dto.UserProblem;

@Transactional
@Repository
public class ProblemImpl implements ProblemDao {
	
	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public Problem getMostResolvedProblem() {
		Criteria criteria = getSession().createCriteria(UserProblem.class);
		return (Problem) criteria.uniqueResult();
	}

	@Override
	public Problem getLeastResolvedProblem() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Problem getProblem(int problemId) {
		return (Problem) getSession().createQuery("from Problem where problemId= :problemId")
				.setParameter("problemId", problemId).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Problem> getAllProblems() {
		return getSession().createQuery("from Product").list();
	}

	@Override
	public void saveNewProblem(Problem problem) {
		getSession().save(problem);
	}

	@Override
	public void updateProblem(Problem problem) {
		getSession().update(problem);
	}

	@Override
	public void deleteProblem(Problem problem) {
		getSession().delete(problem);
	}

}
