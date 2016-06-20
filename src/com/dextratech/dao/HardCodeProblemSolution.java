package com.dextratech.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dextratech.dto.ProblemInputOutput;

@Repository
public class HardCodeProblemSolution implements ProblemSolutionDao {

	@Override
	public List<ProblemInputOutput> getSolutionsForProblemId(int problemId) {
		List<ProblemInputOutput> list = new ArrayList<>();
		
		ProblemInputOutput in = new ProblemInputOutput();
		in.setProblemInputId(1);
		in.setInput("10 5 3 1");
		in.setOutput("1 3 5 10");
		list.add(in);
		in = new ProblemInputOutput();
		in.setProblemInputId(2);
		in.setInput("23 45 65 2");
		in.setOutput("2 23 45 65");
		list.add(in);
		return list;
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
