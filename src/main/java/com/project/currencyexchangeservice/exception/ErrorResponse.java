package com.project.currencyexchangeservice.exception;

public class ErrorResponse {
	
	private String errorMessage;
	private String source;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}	
		
}
