package com.dextratech.dto;

public class UserSolutionDTO {

	private int problemId;
	private String answer;
	private String time;
	
	public int getProblemId() {
		return problemId;
	}
	
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "ProblemSolution [problemId=" + problemId + ", answer=" + answer + "]";
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
