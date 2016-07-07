package com.dextratech.dto;

import java.sql.Timestamp;

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
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="problemId")
	private Problem problem;
	
	private Timestamp elapsedTime;
	private int numberOfTries;
	private String solution;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Timestamp getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(Timestamp elapsedTime) {
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
