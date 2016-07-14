package com.dextratech.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dextratech.dto.Problem;
import com.dextratech.dto.ProblemInputOutput;

@Transactional
@Repository
public class ProblemInputOutputImpl implements ProblemInputOutputDao {

	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProblemInputOutput> getInputsForProblemId(int problemId) {
		Query query = getSession().
				createQuery("Select p.problemInputOutputs from Problem p WHERE p.problemId=:problemId");
		query.setParameter("problemId", problemId);
		return query.list();
	}


	@Override
	public void addInputOutputToProblem(Problem problem,
			ProblemInputOutput input) {
		input.setProblem(problem);
		getSession().persist(input);

	}

	@Override
	public void deleteInputOutputForProblem(ProblemInputOutput input) {
		getSession().delete(input);
	}

	@Override
	public void editInputOutputForProblem(ProblemInputOutput input) {
		getSession().update(input);
	}
	
	
}
