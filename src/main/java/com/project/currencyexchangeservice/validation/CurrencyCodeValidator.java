package com.project.currencyexchangeservice.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class CurrencyCodeValidator implements ConstraintValidator<CurrencyCodeConstraint, String>{

	@Override
	public boolean isValid(String currencyCode, ConstraintValidatorContext context) {		
		List<String> acceptedCurrencyCodes = Arrays.asList("USD","INR","EUR","AUD","JPY","CAD","GBP");		
		return StringUtils.hasLength(currencyCode) && acceptedCurrencyCodes.contains(currencyCode.toUpperCase());
	}

}
