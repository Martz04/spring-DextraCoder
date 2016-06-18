package com.dextratech.dto;

public class OutputSolutionDTO {

	private int inputId;
	private boolean passed;
	private String elapsedTime;
	private String detail;
	
	public int getInputId() {
		return inputId;
	}
	public void setInputId(int inputId) {
		this.inputId = inputId;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public String getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
