package com.dextratech.dto;

public class ProblemParametersDTO {

	private Problem problem;
	private String inputParams;
	private String outputParams;
	
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	public String getInputParams() {
		return inputParams;
	}
	public void setInputParams(String inputParams) {
		this.inputParams = inputParams;
	}
	public String getOutputParams() {
		return outputParams;
	}
	public void setOutputParams(String outputParams) {
		this.outputParams = outputParams;
	}
	@Override
	public String toString() {
		return "ProblemParametersDTO [problem=" + problem + ", inputParams="
				+ inputParams + ", outputParams=" + outputParams + "]";
	}
	
	
}
