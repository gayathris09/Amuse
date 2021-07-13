package com.cg.mts.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Repository.ICustomerRepository;
import com.cg.mts.dto.CustomerDto;
import com.cg.mts.entities.Customer;
import com.cg.mts.util.CustomerConstants;
import com.cg.mts.util.ValidateConstants;

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	/*
	 * Method Name : validateCustomer Parameter : customerDto Return Type : boolean
	 * Author Name: Jyothsna G Created Date : 28-05-2021
	 */
	public boolean validateCustomer(CustomerDto customerDto) throws CustomerNotFoundException {

		if (!customerDto.getUsername().matches(ValidateConstants.USERNAME_PATTERN))
			throw new CustomerNotFoundException(CustomerConstants.CUSTOMER_CANNOT_BE_EMPTY);
		if (!customerDto.getEmail().matches(ValidateConstants.EMAIL_PATTERN))
			throw new CustomerNotFoundException(CustomerConstants.USEREMAIL_CANNOT_BE_EMPTY);
		if (!customerDto.getMobileNumber().matches(ValidateConstants.MOBILENUMBER_PATTERN))
			throw new CustomerNotFoundException(CustomerConstants.INVALID_PHONE);

		return true;
	}
	/*
	 * Method Name : insertCustomer Parameter : customerDto Return Type : Customer
	 * Author Name: Jyothsna G Created Date : 23-05-2021
	 */

	@Override
	public Customer insertCustomer(CustomerDto customerDto) throws CustomerNotFoundException {
		Customer cust = new Customer();
		Optional<Customer> findById = customerRepository.findById(customerDto.getCustomerId());
		if (findById.isPresent())
			throw new CustomerNotFoundException(CustomerConstants.CUSTOMER_EXISTS);

		cust.setCustomerId(customerDto.getCustomerId());
		cust.setUsername(customerDto.getUsername());
		cust.setPassword(customerDto.getPassword());
		cust.setMobileNumber(customerDto.getMobileNumber());
		cust.setEmail(customerDto.getEmail());
		cust.setAddress(customerDto.getAddress());
		validateCustomer(customerDto);
		return customerRepository.save(cust);
	}

	/*
	 * Method Name : updateCustomer Parameter : customerDto Return Type : Customer
	 * Author Name: Jyothsna G Created Date : 26-05-2021
	 */
	@Override
	public Customer updateCustomer(CustomerDto customerDto) throws CustomerNotFoundException {
		Optional<Customer> optCustomer = customerRepository.findById(customerDto.getCustomerId());

		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(CustomerConstants.CUSTOMER_NOT_FOUND);
		Customer customer = optCustomer.get();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setUsername(customerDto.getUsername());
		customer.setPassword(customerDto.getPassword());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmail(customerDto.getEmail());
		customer.setAddress(customerDto.getAddress());
		return customerRepository.save(customer);

	}

	/*
	 * Method Name : viewCustomers Parameter : No Parameter Return Type : List
	 * Author Name: Jyothsna G Created Date : 23-05-2021
	 */
	@Override
	public List<Customer> viewCustomers() throws CustomerNotFoundException {
		List<Customer> customerlist = customerRepository.findAll();
		if (customerlist.isEmpty())
			throw new CustomerNotFoundException(CustomerConstants.CUSTOMER_IS_EMPTY);
		return customerlist;
	}
	
	@Override
	public Customer viewCustomerById(Integer customerId) throws CustomerNotFoundException {
		Optional<Customer> optcustomer = customerRepository.findById(customerId);
		if (!optcustomer.isPresent()) {
			throw new CustomerNotFoundException(CustomerConstants.CUSTOMER_INVALID_ID);

		}
		return optcustomer.get();
	}

}