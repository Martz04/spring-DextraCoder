package com.dextratech.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dextratech.dto.Problem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/dextratech/resources/data-config.xml")
public class ProblemTest {

	@Autowired
	private ProblemDao problemDao;
	
	@Test
	public void testGetProblem() {
		Problem problem = problemDao.getProblem(1);
		System.out.println(problem);
	}
}
