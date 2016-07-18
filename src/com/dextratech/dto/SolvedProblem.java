package com.dextratech.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Solved_Problems")
public class SolvedProblem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userProblemId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="problemId")
	private Problem problem;
	
	private String elapsedTime;
	private int numberOfTries;
	private String solution;
	
	
	
	public int getUserProblemId() {
		return userProblemId;
	}
	public void setUserProblemId(int userProblemId) {
		this.userProblemId = userProblemId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	public String getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public int getNumberOfTries() {
		return numberOfTries;
	}
	public void setNumberOfTries(int numberOfTries) {
		this.numberOfTries = numberOfTries;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	
	
}
