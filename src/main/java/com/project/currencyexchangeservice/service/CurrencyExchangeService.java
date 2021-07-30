package com.project.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.currencyexchangeservice.exception.CurrencyCodesEqualException;
import com.project.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.project.currencyexchangeservice.resource.CurrencyExchange;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Value("${same.currency.codes.error}")
	private String sameCurrencyCodeMessage;
	
	public CurrencyExchange findLatestRecordByFromAndTo(String fromCurrencyCode, String toCurrencyCode) throws CurrencyCodesEqualException {
		if(fromCurrencyCode.equals(toCurrencyCode)) {
			throw new CurrencyCodesEqualException(sameCurrencyCodeMessage);
		}
		return currencyExchangeRepository.findLatestRecordByFromAndTo(fromCurrencyCode, toCurrencyCode).findFirst().orElse(new CurrencyExchange());
	}
}
