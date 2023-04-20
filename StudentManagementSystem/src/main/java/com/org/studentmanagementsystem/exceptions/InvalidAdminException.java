package com.org.studentmanagementsystem.exceptions;

public class InvalidAdminException extends RuntimeException {
	
	private final String message;

	public InvalidAdminException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	

}
