package com.dextratech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dextratech.dto.Problem;

@Transactional
@Repository
public class ProblemImpl implements ProblemDao {
	
	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
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
