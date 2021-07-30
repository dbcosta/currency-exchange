package com.project.currencyexchangeservice.exception;

public class CurrencyCodesEqualException extends Exception{	
	private static final long serialVersionUID = 1L;
	
	public CurrencyCodesEqualException(String sameCurrencyCodeMessage) {
		super(sameCurrencyCodeMessage);
	}
}
