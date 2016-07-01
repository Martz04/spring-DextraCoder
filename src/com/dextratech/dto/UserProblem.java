package com.dextratech.dto;

import java.sql.Timestamp;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="User_has_Problem")
@AssociationOverrides({
	@AssociationOverride(name="id.user", joinColumns = {@JoinColumn(name="userId")}),
	@AssociationOverride(name="id.problem", joinColumns = {@JoinColumn(name="problemId")})
})
public class UserProblem {

	@EmbeddedId
	private UserProblemPK id = new UserProblemPK();
	
	private Timestamp elapsedTime;
	private int numberOfTries;
	private String solution;
	
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
	public UserProblemPK getId() {
		return id;
	}
	public void setId(UserProblemPK id) {
		this.id = id;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	
	
}
