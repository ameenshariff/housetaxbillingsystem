package com.as.housetaxbillingsystem.service;

import com.as.housetaxbillingsystem.entity.Customer;
import com.as.housetaxbillingsystem.entity.Login;
import com.as.housetaxbillingsystem.exception.InvalidCustomerException;

public interface LoginService {
	boolean registerCustomer(Customer customer);

	void login(Login login);

	boolean validateLogin(String userName, String password) throws InvalidCustomerException;
}