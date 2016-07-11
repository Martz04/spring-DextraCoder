package com.dextratech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dextratech.dto.Problem;
import com.dextratech.dto.SolvedProblem;
import com.dextratech.dto.User;

@Repository
@Transactional
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

	@SuppressWarnings("unchecked")
	@Override
	public List<SolvedProblem> getSolvedProblemsForUser(User user) {
		Criteria criteria = getSession().createCriteria(SolvedProblem.class);
		criteria.setFetchMode("user", FetchMode.JOIN)
			.add(Restrictions.eq("user.userId", user.getUserId()))
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Problem> getUnsolvedProblemsForUser(User user) {
		Query query = getSession().
				createQuery("select sp.problem from SolvedProblem as sp right join sp.problem left join sp.user s where (s is null or s.userId!=:userId)");
		query.setParameter("userId", user.getUserId());
		query.setMaxResults(10);
		return query.list();
	}

	
}
