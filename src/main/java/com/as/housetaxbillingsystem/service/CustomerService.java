package com.as.housetaxbillingsystem.service;

import java.util.List;

import com.as.housetaxbillingsystem.entity.Customer;

public interface CustomerService {

	Customer getCustomerDetails(String userName);
	
	List<Customer> getAllCustomers();
	
	void updateCustomer(Customer customer);

	void deleteCustomer(int custId);
}
