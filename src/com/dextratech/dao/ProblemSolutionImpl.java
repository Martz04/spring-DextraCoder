package com.dextratech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dextratech.dto.ProblemInputOutput;

@Transactional
@Repository
public class ProblemSolutionImpl implements ProblemSolutionDao {

	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProblemInputOutput> getSolutionsForProblemId(int problemId) {
		return getSession().
				createQuery("Select problemInputOutputs from Problem p where p.problemId = :problemId").
				setParameter("problemId", problemId).list();
	}

	@Override
	public void addInputOutputToProblemId(int problemId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteInputOutputForProblemId(int problemId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editInputOutputForProblemId(int problemId) {
		// TODO Auto-generated method stub

	}

}
