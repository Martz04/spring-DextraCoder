package com.dextratech.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserProblemPK implements Serializable{
	private static final long serialVersionUID = 6842072545117001212L;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Problem problem;
	
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
}
