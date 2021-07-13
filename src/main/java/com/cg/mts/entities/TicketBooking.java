package com.cg.mts.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticketbooking")
public class TicketBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketBookingId;

	@OneToOne
	@JoinColumn(name = "activityId")
	private Activity activity;

	@Column(name = "date_of_visiting")
	private LocalDate dateOfVisiting;

	@Column(name = "Bill")
	private Float bill;

	@Column(name = "date_of_booking")
	private LocalDate dateOfBooking;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Integer getTicketBookingId() {
		return ticketBookingId;
	}

	public void setTicketBookingId(Integer ticketBookingId) {
		this.ticketBookingId = ticketBookingId;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public LocalDate getDateOfVisiting() {
		return dateOfVisiting;
	}

	public void setDateOfVisiting(LocalDate dateOfVisiting) {
		this.dateOfVisiting = dateOfVisiting;
	}

	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public Float getBill() {
		return bill;
	}

	public void setBill(Float bill) {
		this.bill = bill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}