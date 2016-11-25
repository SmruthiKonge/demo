package com.smriti.services;

import java.util.List;

import com.smriti.model.Customer;

public interface CustomerService {
	
	void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername (String username);

}

