package com.as.housetaxbillingsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.as.housetaxbillingsystem.entity.Admin;
import com.as.housetaxbillingsystem.exception.NoAdminFoundException;
import com.as.housetaxbillingsystem.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo repo;

	/**
	 *checks if the person logged in is user/admin
	 */
	@Override
	public boolean isUser(String userName) {
		if (repo.existsById(userName)) {
			return false;
		} else
			return true;
	}
	
	
	/**
	 *Checks if admin is present
	 *if present password is validated and returned true
	 *else returned false
	 *
	 */
	@Override
	public boolean validateAdminLogin(String userName, String password) throws NoAdminFoundException {
		Admin adminFromDb;
		try {
			adminFromDb = repo.findById(userName).get();
		} catch (Exception e) {
			throw new NoAdminFoundException("No Admin with User Name : " + userName);
		}

		if (adminFromDb != null) {
			if (new BCryptPasswordEncoder().matches(password, adminFromDb.getPassword()))
				return true;
			else
				return false;
		} else
			return false;
	}

}
