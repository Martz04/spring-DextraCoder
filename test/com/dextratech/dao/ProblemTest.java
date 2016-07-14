package com.dextratech.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dextratech.dto.Problem;
import com.dextratech.dto.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/dextratech/resources/data-config.xml")
public class ProblemTest {

	@Autowired
	private ProblemDao problemDao;
	
	@Autowired
	private SolvedProblemDao solvedDao;
	
	@Test
	public void testGetProblem() {
		Problem problem = problemDao.getProblem(1);
		Assert.assertNotNull(problem);
	}
	
	@Test
	public void testGettingUserSolvedProblem() {
		Problem problem = problemDao.getProblem(1);
		List<User> users = solvedDao.getUsersSolvedProblem(problem);
		Assert.assertTrue(users.size() > 0);
	}
}
