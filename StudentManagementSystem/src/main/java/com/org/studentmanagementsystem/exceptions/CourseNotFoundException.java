package com.org.studentmanagementsystem.exceptions;

public class CourseNotFoundException extends RuntimeException{
	
	private final String message;

	public CourseNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
