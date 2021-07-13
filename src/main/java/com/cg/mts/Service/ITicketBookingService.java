package com.cg.mts.Service;

import java.util.List;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Exception.TicketBookingNotFoundException;
import com.cg.mts.dto.TicketBookingDto;
import com.cg.mts.entities.TicketBooking;

public interface ITicketBookingService {

	public TicketBooking bookTicket(TicketBookingDto ticketBookingDto) throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException;

	public TicketBooking updateTicket(TicketBookingDto ticketBookingDto) throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException;

	public List<TicketBooking> viewAllTickets() throws TicketBookingNotFoundException;
}