package com.dextratech.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Problem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int problemId;
	
	private String title;
	private String description;
	private String inputDescription;
	private String outputDescription;
	
	private int timesSolved;
	
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval=false, cascade =CascadeType.ALL)
	@JoinColumn(name="problemId")
	private List<ProblemInputOutput> problemInputOutputs;
	
	@OneToMany(mappedBy = "id.problem", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	private Set<UserProblem> usersPassed = new HashSet<>();
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
	public List<ProblemInputOutput> getProblemInputOutputs() {
		return problemInputOutputs;
	}
	public void setProblemInputOutputs(List<ProblemInputOutput> problemInputOutputs) {
		this.problemInputOutputs = problemInputOutputs;
	}
	
	public String getInputDescription() {
		return inputDescription;
	}
	public void setInputDescription(String inputDescription) {
		this.inputDescription = inputDescription;
	}
	public String getOutputDescription() {
		return outputDescription;
	}
	public void setOutputDescription(String outputDescription) {
		this.outputDescription = outputDescription;
	}
	@Override
	public String toString() {
		return "Problem [problemId=" + problemId + ", title=" + title + ", description=" + description
				+ ", inputDescription=" + inputDescription + ", outputDescription=" + outputDescription
				+ ", timesSolved=" + timesSolved + ", problemInputOutputs=" + problemInputOutputs + "]";
	}
	
	
	
}
