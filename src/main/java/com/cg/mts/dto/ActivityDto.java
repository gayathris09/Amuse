package com.cg.mts.dto;

public class ActivityDto {
	private Integer activityId;
	private Float charges;
	private String description;

	public ActivityDto() {
		super();
	}

	public ActivityDto(Integer activityId, Float charges, String description) {
		super();
		this.activityId = activityId;
		this.charges = charges;
		this.description = description;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Float getCharges() {
		return charges;
	}

	public void setCharges(Float charges) {
		this.charges = charges;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
