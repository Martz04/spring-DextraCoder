package com.dextratech.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProblemInputOutput {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="problemInputOutputId")
	private int problemInputOutputId;
	private String input;
	private String output;
	
	@ManyToOne
	@JoinColumn(name="problemId")
	private Problem problem;
	
	public int getProblemInputOutputId() {
		return problemInputOutputId;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	
	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public void setProblemInputOutputId(int problemInputOutputId) {
		this.problemInputOutputId = problemInputOutputId;
	}

	@Override
	public String toString() {
		return "ProblemInputOutput [problemInputOutputId=" + problemInputOutputId + ", input=" + input + ", output=" + output + "]";
	}
	
	
}
