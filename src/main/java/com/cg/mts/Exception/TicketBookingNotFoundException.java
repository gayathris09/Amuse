package com.cg.mts.Exception;

public class TicketBookingNotFoundException extends Exception {
	public TicketBookingNotFoundException() {
		super();
	}

	private static final long serialVersionUID = 1L;

	public TicketBookingNotFoundException(String s) {
		super(s);
	}
}
