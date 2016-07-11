package com.dextratech.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dextratech.dto.Problem;
import com.dextratech.dto.SolvedProblem;
import com.dextratech.dto.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/dextratech/resources/data-config.xml")
public class UsuarioTest {

	@Autowired
	private UserDao userDao;
	@Autowired
	private SolvedProblemDao solvedDao;
	
	@Test
	public void testGetUser() {
		User user = userDao.getUserById(1); 
		Assert.assertEquals("Mario", user.getName());
	}
	
	@Test
	public void testGetSolvedProblems() {
		User user = userDao.getUserById(1);
		List<SolvedProblem> problem = solvedDao.getSolvedProblemsForUser(user);
		Assert.assertEquals(3, problem.get(0).getProblem().getProblemId());
	}
	
	@Test
	public void testGetUnsolvedProblems() {
		User user = userDao.getUserById(1);
		List<Problem> problems = solvedDao.getUnsolvedProblemsForUser(user);
		System.out.println(problems);
	}
}
