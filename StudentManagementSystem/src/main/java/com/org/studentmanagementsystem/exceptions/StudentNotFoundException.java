package com.org.studentmanagementsystem.exceptions;

public class StudentNotFoundException extends RuntimeException{
	
	private final String message;

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
