package com.as.housetaxbillingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.housetaxbillingsystem.entity.Customer;
import com.as.housetaxbillingsystem.entity.Login;
import com.as.housetaxbillingsystem.exception.InvalidCustomerException;
import com.as.housetaxbillingsystem.repo.CustomerRepo;
import com.as.housetaxbillingsystem.repo.LoginRepo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepo repo;

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public boolean registerCustomer(Customer customer) {
		if (repo.findByUserName(customer.getUserName()) == null) {
			repo.save(customer);
			return false;
		}
			
		else
			return true;

	}

	@Override
	public void login(Login login) {
		loginRepo.save(login);
	}

	@Override
	public boolean validateLogin(String userName, String password) throws InvalidCustomerException {
		Login loginFromDb;
		try {
			loginFromDb = loginRepo.findById(userName).get();
		} catch (Exception e) {
			throw new InvalidCustomerException("No Customer with User Name : " + userName);
		}

		if (loginFromDb != null) {
			if (loginFromDb.getPassword().equals(password))
				return true;
			else
				return false;
		} else
			return false;
	}

}
