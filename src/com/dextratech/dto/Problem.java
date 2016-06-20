package com.dextratech.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Problem {

	@Id
	@GeneratedValue
	private int problemId;
	
	private String title;
	private String description;
	private int timesSolved;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTimesSolved() {
		return timesSolved;
	}
	public void setTimesSolved(int timesSolved) {
		this.timesSolved = timesSolved;
	}
	
	
}
