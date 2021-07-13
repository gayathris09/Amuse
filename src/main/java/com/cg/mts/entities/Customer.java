package com.cg.mts.entities;

import javax.persistence.*;

@Entity
public class Customer extends AbstractUser {

	private Integer customerId;
	private String type = "Customer";

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}