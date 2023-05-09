package com.org.studentmanagementsystem.util;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.org.studentmanagementsystem.exceptions.CourseNotFoundException;
import com.org.studentmanagementsystem.exceptions.DuplicateAdminException;
import com.org.studentmanagementsystem.exceptions.DuplicateStudentException;
import com.org.studentmanagementsystem.exceptions.InvalidAdminException;
import com.org.studentmanagementsystem.exceptions.StudentNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { CourseNotFoundException.class, DuplicateAdminException.class,
			DuplicateStudentException.class, InvalidAdminException.class, StudentNotFoundException.class,
			Exception.class })
	public ResponseEntity<ErrorResponse> handleGlobalException(WebRequest request, Exception e) {

		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDate.now());
		response.setStatus(HttpStatus.BAD_REQUEST.name());
		response.setError(e.getMessage());
		response.setPath(request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
