package com.cg.mts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Service.CustomerServiceImp;
import com.cg.mts.dto.CustomerDto;
import com.cg.mts.dto.SuccessMessageDto;
import com.cg.mts.entities.Activity;
import com.cg.mts.entities.Customer;
import com.cg.mts.util.CustomerConstants;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

	@Autowired
	CustomerServiceImp customerService;

	/*
	 * Method Name : insertCustomer Parameter : customerDto Return Type : Customer
	 * Author Name: Jyothsna G Created Date : 23-05-2021
	 */

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public SuccessMessageDto insertCustomer(@RequestBody CustomerDto customerDto) throws CustomerNotFoundException {
		Customer customer = customerService.insertCustomer(customerDto);
		return new SuccessMessageDto(CustomerConstants.CUSTOMER_ADDED + customer.getCustomerId());
	}

	/*
	 * Method Name : viewCustomers Parameter : No Parameter Return Type : List
	 * Author Name: Jyothsna G Created Date : 23-05-2021
	 */
	@GetMapping("/all")
	public List<Customer> getCustomer() throws CustomerNotFoundException {
		return customerService.viewCustomers();
	}

	/*
	 * Method Name : updateCustomer Parameter : customerDto Return Type : Customer
	 * Author Name: Jyothsna G Created Date : 26-05-2021
	 */
	@PutMapping("/updatecustomer")
	public SuccessMessageDto updateCustomer(@RequestBody CustomerDto customerDto) throws CustomerNotFoundException {
		Customer customer = customerService.updateCustomer(customerDto);

		return new SuccessMessageDto(CustomerConstants.CUSTOMER_UPDATED + customer.getCustomerId());
	}
	
	
	@GetMapping("/getcustomerbyid/{id}")
	public Customer viewCustomerById(@PathVariable("id") Integer id) throws CustomerNotFoundException {

		return customerService.viewCustomerById(id);
	}


}