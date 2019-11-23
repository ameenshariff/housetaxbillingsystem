package com.as.housetaxbillingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.housetaxbillingsystem.entity.Customer;
import com.as.housetaxbillingsystem.entity.Login;
import com.as.housetaxbillingsystem.exception.InvalidCustomerException;
import com.as.housetaxbillingsystem.repo.CustomerRepo;
import com.as.housetaxbillingsystem.repo.LoginRepo;

@Service
@Transactional
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
		String encodedPassword = encoder.encode(login.getPassword());
		System.out.println("Encoded password "+encodedPassword);
		login.setPassword(encodedPassword);
		loginRepo.save(login);
	}

	@Override
	public boolean validateLogin(String userName, String password) throws InvalidCustomerException {
		Login loginFromDb;
		try {
			loginFromDb = loginRepo.findById(userName).get();
			System.out.println(loginFromDb.getPassword()+"         "+password);
		} catch (Exception e) {
			throw new InvalidCustomerException("No Customer with User Name : " + userName);
		}

		if (loginFromDb != null) {
			
			if (new BCryptPasswordEncoder().matches(password, loginFromDb.getPassword()))
				return true;
			else
				return false;
		} else
			return false;
	}

}
