package com.cg.mts.Service;

import java.util.List;

import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.dto.CustomerDto;
import com.cg.mts.entities.Customer;

public interface ICustomerService {
	public Customer insertCustomer(CustomerDto customerDto) throws CustomerNotFoundException;

	public Customer updateCustomer(CustomerDto customerDto) throws CustomerNotFoundException;

	public List<Customer> viewCustomers() throws CustomerNotFoundException;
	
	public Customer viewCustomerById(Integer customerId) throws CustomerNotFoundException;

}
