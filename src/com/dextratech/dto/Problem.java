package com.dextratech.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="problemId")
	private int problemId;
	private String title;
	private String description;
	private String inputDescription;
	private String outputDescription;
	
	private int timesSolved;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="problemId", nullable=false, updatable=true, insertable=true)
	private List<ProblemInputOutput> problemInputOutputs;
	
	@OneToMany(mappedBy = "problem", fetch= FetchType.LAZY)
	private Set<AssignedProblem> assignedProblems = new HashSet<>();
	
	@OneToMany(mappedBy = "problem")
	private Set<SolvedProblem> userProblem = new HashSet<>();
	
	public int getProblemId() {
		return problemId;
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
	
	
	public Set<SolvedProblem> getUserProblem() {
		return userProblem;
	}

	public void setUserProblem(Set<SolvedProblem> userProblem) {
		this.userProblem = userProblem;
	}

	@Override
	public String toString() {
		return "Problem [problemId=" + problemId + ", title=" + title + ", description=" + description
				+ ", inputDescription=" + inputDescription + ", outputDescription=" + outputDescription
				+ ", timesSolved=" + timesSolved + ", problemInputOutputs=" + problemInputOutputs + "]";
	}
	
	
	
}
