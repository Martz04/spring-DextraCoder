package com.dextratech.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="roleId")
	private int roleId;
	private String description;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	public int getRoleId() {
		return roleId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
