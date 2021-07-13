package com.cg.mts.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends AbstractUser {

	private Integer adminId;
	private String type = "Admin";

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}