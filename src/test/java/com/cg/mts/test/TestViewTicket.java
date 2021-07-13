package com.cg.mts.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.mts.Exception.TicketBookingNotFoundException;
import com.cg.mts.Repository.ITicketBookingRepository;
import com.cg.mts.Service.ITicketBookingService;
import com.cg.mts.Service.TicketBookingServiceImp;

@SpringBootTest
public class TestViewTicket {

	@Mock
	ITicketBookingRepository ticketBookingRepository;

	@InjectMocks
	ITicketBookingService bookingService = new TicketBookingServiceImp();

	@Test
	public void testViewActivityById2() throws TicketBookingNotFoundException {
		assertThrows(TicketBookingNotFoundException.class, () -> bookingService.viewAllTickets());
	}

}
