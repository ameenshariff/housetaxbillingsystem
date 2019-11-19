package com.as.housetaxbillingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.housetaxbillingsystem.entity.Customer;
import com.as.housetaxbillingsystem.service.CustomerService;

/**
 * @author ameen shariff
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")

//@CrossOrigin(origins = "http://ameenshariff.github.io")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	/**
	 * @param userName
	 * @return a customer is returned by user name
	 */
	@GetMapping("/getCustomerDetails/{userName}")
	public Customer getCustomerDetails(@PathVariable String userName) {
		return service.getCustomerDetails(userName);
	}
	
	/**
	 * @return all the customers in database
	 */
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	/**
	 * @param customer
	 * Updates the customer
	 */
	@PutMapping("/updateEditedCustomers")
	public void updateEditedCustomers(@RequestBody Customer customer) {
		service.updateCustomer(customer);
	}
	
	/**
	 * @param custId
	 * deletes the customer by using customer Id
	 */
	@DeleteMapping("/deleteCustomer/{custId}")
	public void deleteCustomer(@PathVariable int custId) {
		System.out.println("ajmal deleted...................");
		service.deleteCustomer(custId);
	}
	

}
