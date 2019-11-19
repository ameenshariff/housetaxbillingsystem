package com.as.housetaxbillingsystem.service;

import com.as.housetaxbillingsystem.exception.NoAdminFoundException;

public interface AdminService {
	boolean isUser(String userName);
	
	boolean validateAdminLogin(String userName, String password) throws NoAdminFoundException;

}
