package com.dextratech.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<Roles> roles;
	
	@OneToMany(mappedBy = "user", fetch= FetchType.LAZY)
	private Set<SolvedProblem> solvedProblems = new HashSet<>();
	
	@OneToMany(mappedBy = "user", fetch= FetchType.EAGER)
	private Set<AssignedProblem> assignedProblems = new HashSet<>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	
	public Set<SolvedProblem> getSolvedProblems() {
		return solvedProblems;
	}
	public void setSolvedProblems(Set<SolvedProblem> solvedProblems) {
		this.solvedProblems = solvedProblems;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", roles=" + roles
				+ "]";
	}
	
	
	
}
