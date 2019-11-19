package com.as.housetaxbillingsystem.exception;

public class NoAdminFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public NoAdminFoundException(String message) {
		super(message);
	}

}
