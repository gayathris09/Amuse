package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Activity")
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer activityId;
	private String description;
	private Float charges;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getCharges() {
		return charges;
	}

	public void setCharges(Float charges) {
		this.charges = charges;
	}

}