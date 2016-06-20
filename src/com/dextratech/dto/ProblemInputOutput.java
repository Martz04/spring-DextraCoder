package com.dextratech.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProblemInputOutput {

	@Id
	@GeneratedValue
	private int problemInputId;
	private String input;
	private String output;
	
	public int getProblemInputId() {
		return problemInputId;
	}
	public void setProblemInputId(int problemInputId) {
		this.problemInputId = problemInputId;
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
	
	
}
