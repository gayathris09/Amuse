package com.cg.mts.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Repository.ICustomerRepository;
import com.cg.mts.Service.CustomerServiceImp;
import com.cg.mts.Service.ICustomerService;
import com.cg.mts.dto.CustomerDto;
import com.cg.mts.entities.Customer;

@SpringBootTest
public class TestUpdateCustomer {
	@Mock
	private ICustomerRepository customerDao;

	@InjectMocks
	private ICustomerService customerService = new CustomerServiceImp();

	@BeforeEach
	public void berforeEach() {
		when(customerDao.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerDao.findById(2)).thenReturn(Optional.empty());
		when(customerDao.save(any(Customer.class))).thenReturn(new Customer());

	}

	@Test
	public void testUpdateCustomer1() throws CustomerNotFoundException {
		CustomerDto dto = new CustomerDto(1, "jyothsna", "jyothsna@13", "7893403126", "jyothsna@gmail.com",
				"hyderabad");

		assertNotNull(customerService.updateCustomer(dto));

	}

	@Test
	public void testUpdateCustomer2() throws CustomerNotFoundException {
		CustomerDto dto = new CustomerDto(2, "jyothsna", "jyothsna@13", " ", "jyothsna@gmail.com", "hyderabad");
		assertThrows(CustomerNotFoundException.class, () -> customerService.updateCustomer(dto));

	}

}
