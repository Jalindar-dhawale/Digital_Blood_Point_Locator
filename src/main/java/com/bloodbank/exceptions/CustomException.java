package com.bloodbank.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception{
	private static final long serialVersionUID = 1L;
	private HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
	private Exception exceptions;
	private String message;
	private CustomException() {};
	public static CustomException build(String message) {
		CustomException customException=new CustomException();
		customException.message=message;
		return customException;
	}
	public CustomException withStatus(HttpStatus httpStatus) {
		this.status=httpStatus;
		return this;
	}
	public CustomException withException(Exception exception) {
		this.exceptions=exception;
		return this;
	}
	public HttpStatus getStatus() {
		return status;
	}

	public Exception getExceptions() {
		return exceptions;
	}

	public String getMessage() {
		return message;
	}
	
}
