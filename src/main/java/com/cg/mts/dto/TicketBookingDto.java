package com.cg.mts.dto;

import java.time.LocalDate;

public class TicketBookingDto {

	private Integer ticketBookingId;
	private Integer activityId;
	private Integer customerId;
	private LocalDate dateOfVisting;

	public TicketBookingDto() {
		super();
	}

	public TicketBookingDto(Integer ticketBookingId, Integer activityId, Integer customerId, LocalDate dateOfVisting) {
		super();
		this.setTicketBookingId(ticketBookingId);
		this.activityId = activityId;
		this.customerId = customerId;
		this.dateOfVisting = dateOfVisting;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public LocalDate getDateOfVisting() {
		return dateOfVisting;
	}

	public void setDateOfVisting(LocalDate dateOfVisting) {
		this.dateOfVisting = dateOfVisting;
	}

	public Integer getTicketBookingId() {
		return ticketBookingId;
	}

	public void setTicketBookingId(Integer ticketBookingId) {
		this.ticketBookingId = ticketBookingId;
	}

}