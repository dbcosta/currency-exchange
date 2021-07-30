package com.project.currencyexchangeservice.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CurrencyExchangeControllerAdvice {

	@Value("${unacceptable.currency.codes.error}")
	private String unacceptableErrorCodesMessage;
	
	@ExceptionHandler(value = CurrencyCodesEqualException.class)	
	public ResponseEntity<ErrorResponse> handleCurrencyCodesEqualException(CurrencyCodesEqualException currencyCodesEqualException){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(currencyCodesEqualException.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<List<ErrorResponse>> handleConstraintViolationException(ConstraintViolationException constraintViolationException){
		Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
		List<ErrorResponse> errorResponses = new ArrayList<>();
		for(ConstraintViolation<?> constraintViolation:constraintViolations) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorMessage(unacceptableErrorCodesMessage);
			errorResponse.setSource(constraintViolation.getInvalidValue().toString());
			errorResponses.add(errorResponse);
		}
		return new ResponseEntity<List<ErrorResponse>>(errorResponses,HttpStatus.BAD_REQUEST);
	}
}
