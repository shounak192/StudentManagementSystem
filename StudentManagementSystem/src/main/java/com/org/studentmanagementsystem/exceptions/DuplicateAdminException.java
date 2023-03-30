package com.org.studentmanagementsystem.exceptions;

public class DuplicateAdminException extends RuntimeException {
	
	private final String message;

	public DuplicateAdminException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	
	
	

}
