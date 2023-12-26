package com.sigma.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMessage;
	private String errorCode;

	public ValidationException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public ValidationException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return super.toString();
	}



}
