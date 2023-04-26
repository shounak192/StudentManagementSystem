package com.org.studentmanagementsystem.exceptions;

public class DuplicateStudentException extends RuntimeException {
	
	private final String message;

	public DuplicateStudentException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
