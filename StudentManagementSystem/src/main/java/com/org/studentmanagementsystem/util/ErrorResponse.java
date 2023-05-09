package com.org.studentmanagementsystem.util;

import java.time.LocalDate;

public class ErrorResponse {

	private LocalDate timestamp;
	private String status;
	private String error;
	private String path;

	public ErrorResponse(LocalDate timestamp, String status, String error, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.path = path;
	}

	public ErrorResponse() {
		super();
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
