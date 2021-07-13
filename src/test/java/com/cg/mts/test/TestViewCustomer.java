package com.cg.mts.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Repository.ICustomerRepository;
import com.cg.mts.Service.CustomerServiceImp;
import com.cg.mts.Service.ICustomerService;
import com.cg.mts.entities.Customer;

@SpringBootTest
public class TestViewCustomer {
	@Mock
	private ICustomerRepository customerDao;

	@InjectMocks
	private ICustomerService customerService = new CustomerServiceImp();

	@BeforeEach
	public void berforeEach() {
		when(customerDao.findById(3)).thenReturn(Optional.of(new Customer()));
		when(customerDao.findById(4)).thenReturn(Optional.empty());
	}

	@Test
	public void testViewCustomer1() throws CustomerNotFoundException {
		assertThrows(CustomerNotFoundException.class, () -> customerService.viewCustomers());
	}

	@Test
	public void testViewCustomer2() throws CustomerNotFoundException {
		assertThrows(CustomerNotFoundException.class, () -> customerService.viewCustomers());
	}

}