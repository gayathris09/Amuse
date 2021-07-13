package com.cg.mts.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Exception.TicketBookingNotFoundException;
import com.cg.mts.Repository.IActivityRepository;
import com.cg.mts.Repository.ICustomerRepository;
import com.cg.mts.Repository.ITicketBookingRepository;
import com.cg.mts.Service.ITicketBookingService;
import com.cg.mts.Service.TicketBookingServiceImp;
import com.cg.mts.dto.TicketBookingDto;
import com.cg.mts.entities.Activity;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.TicketBooking;

@SpringBootTest
public class TestUpdateTicket {

	@Mock
	private ITicketBookingRepository ticketBookingRepo;

	@Mock
	private ICustomerRepository customerRepo;

	@Mock
	private IActivityRepository activityRepo;

	@InjectMocks
	ITicketBookingService bookingService = new TicketBookingServiceImp();

	@BeforeEach
	public void beforeEach() {
		when(customerRepo.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerRepo.findById(2)).thenReturn(Optional.empty());
		when(activityRepo.findById(1)).thenReturn(Optional.of(new Activity()));
		when(activityRepo.findById(2)).thenReturn(Optional.empty());
		when(ticketBookingRepo.findById(1)).thenReturn(Optional.of(new TicketBooking()));
		when(ticketBookingRepo.findById(2)).thenReturn(Optional.empty());
		when(ticketBookingRepo.save(any(TicketBooking.class))).thenReturn(new TicketBooking());
	}

	@Test
	public void testUpdateTicket1()
			throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException {
		TicketBookingDto ticketBookingDto = new TicketBookingDto(1, 1, 1, LocalDate.of(2021, 6, 17));
		assertNotNull(bookingService.updateTicket(ticketBookingDto));
	}

	@Test
	public void testUpdateTicket2()
			throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException {
		TicketBookingDto ticketBookingDto = new TicketBookingDto(1, 2, 1, LocalDate.of(2021, 6, 17));
		assertThrows(ActivityNotFoundException.class, () -> bookingService.updateTicket(ticketBookingDto));
	}

	@Test
	public void testUpdateTicket3()
			throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException {
		TicketBookingDto ticketBookingDto = new TicketBookingDto(1, 1, 2, LocalDate.of(2021, 6, 17));
		assertThrows(CustomerNotFoundException.class, () -> bookingService.updateTicket(ticketBookingDto));
	}

	@Test
	public void testUpdateTicket4()
			throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException {
		TicketBookingDto ticketBookingDto = new TicketBookingDto(1, 1, 1, LocalDate.of(2021, 3, 17));
		assertThrows(TicketBookingNotFoundException.class, () -> bookingService.updateTicket(ticketBookingDto));
	}
}