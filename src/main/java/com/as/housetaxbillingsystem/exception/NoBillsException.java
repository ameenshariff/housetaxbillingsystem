package com.as.housetaxbillingsystem.exception;

public class NoBillsException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public NoBillsException(String message) {
		super(message);
	}

}
