package com.dextratech.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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
	@Column(name="userId")
	private int userId;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "user", fetch= FetchType.EAGER)
	private Set<Rol> roles;
	
	@OneToMany(mappedBy = "user", fetch= FetchType.LAZY)
	private Set<SolvedProblem> solvedProblems = new HashSet<>();
	
	@OneToMany(mappedBy = "user", fetch= FetchType.EAGER)
	private Set<AssignedProblem> assignedProblems = new HashSet<>();
	
	public int getUserId() {
		return userId;
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
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
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
