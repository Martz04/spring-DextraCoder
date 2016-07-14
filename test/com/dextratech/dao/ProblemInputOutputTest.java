package com.dextratech.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dextratech.dto.Problem;
import com.dextratech.dto.ProblemInputOutput;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/dextratech/resources/data-config.xml")
public class ProblemInputOutputTest {

	@Autowired
	private ProblemInputOutputDao problemInputDao;
	@Autowired
	private ProblemDao problemDao;
	private static final int ID = 1;
	private static ProblemInputOutput test; 
	
	@BeforeClass
	public static void createInput() {
		test = new ProblemInputOutput();
		test.setInput("Test");
		test.setOutput("test");
	}
	
	@Test
	public void testGettingProblemInputOutput() {
		List<ProblemInputOutput> inputs = problemInputDao.getInputsForProblemId(ID);
		Assert.assertNotNull(inputs);
	}
	
	@Test
	public void testAddingProblem(){
		Problem problem = problemDao.getProblem(ID);
		problemInputDao.addInputOutputToProblem(problem, test);
		test.setInput("Test 2");
		problemInputDao.editInputOutputForProblem(test);
	}
	
	@Test
	public void testDeletingProblem() {
		Problem problem = problemDao.getProblem(ID);
		for(ProblemInputOutput input : problem.getProblemInputOutputs()) {
			if(input.getOutput().equals("test")) {
				problemInputDao.deleteInputOutputForProblem(input);
			}
		}
	}
}
