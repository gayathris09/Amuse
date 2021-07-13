package com.cg.mts.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
public class TestBookTicket {

	@Mock
	ICustomerRepository customerRepo;

	@Mock
	IActivityRepository activityRepo;

	@Mock
	ITicketBookingRepository ticketBookingRepository;

	@InjectMocks
	ITicketBookingService bookingService = new TicketBookingServiceImp();

	@BeforeEach
	public void beforeEach() {
		when(customerRepo.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerRepo.findById(2)).thenReturn(Optional.empty());
		when(activityRepo.findById(1)).thenReturn(Optional.of(new Activity()));
		when(activityRepo.findById(2)).thenReturn(Optional.empty());
		when(ticketBookingRepository.findById(1)).thenReturn(Optional.of(new TicketBooking()));
		when(ticketBookingRepository.findById(2)).thenReturn(Optional.empty());
		when(ticketBookingRepository.save(any(TicketBooking.class))).thenReturn(new TicketBooking());
	}

	@Test
	public void testBookTicket1()
			throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException {
		TicketBookingDto ticketBookingDto = new TicketBookingDto(1, 1, 1, LocalDate.of(2021, 6, 17));
		assertNotNull(bookingService.bookTicket(ticketBookingDto));
	}

	@Test
	public void testBookTicket2()
			throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException {
		TicketBookingDto ticketBookingDto = new TicketBookingDto(1, 2, 1, LocalDate.of(2021, 6, 17));
		assertThrows(ActivityNotFoundException.class, () -> bookingService.bookTicket(ticketBookingDto));
	}

	@Test
	public void testBookTicket3()
			throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException {
		TicketBookingDto ticketBookingDto = new TicketBookingDto(1, 1, 2, LocalDate.of(2021, 6, 17));
		assertThrows(CustomerNotFoundException.class, () -> bookingService.bookTicket(ticketBookingDto));
	}

	@Test
	public void testBookTicket4()
			throws CustomerNotFoundException, ActivityNotFoundException, TicketBookingNotFoundException {
		TicketBookingDto ticketBookingDto = new TicketBookingDto(1, 1, 1, LocalDate.of(2021, 3, 17));
		assertThrows(TicketBookingNotFoundException.class, () -> bookingService.bookTicket(ticketBookingDto));
	}
}