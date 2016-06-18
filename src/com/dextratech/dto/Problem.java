package com.dextratech.dto;

import java.util.List;

//@Entity
public class Problem {

	private int problemId;
	private String description;
	private List<ProblemInputOutput> problemInputOutputs;
	
	public int getProblemId() {
		return problemId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ProblemInputOutput> getProblemInputOutputs() {
		return problemInputOutputs;
	}
	public void setProblemInputOutputs(List<ProblemInputOutput> problemInputOutputs) {
		this.problemInputOutputs = problemInputOutputs;
	}
	
	
}
