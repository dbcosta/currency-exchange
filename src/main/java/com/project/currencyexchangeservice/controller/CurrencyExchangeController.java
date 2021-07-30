package com.project.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.currencyexchangeservice.exception.CurrencyCodesEqualException;
import com.project.currencyexchangeservice.resource.CurrencyExchange;
import com.project.currencyexchangeservice.service.CurrencyExchangeService;
import com.project.currencyexchangeservice.validation.CurrencyCodeConstraint;

@RestController
@Validated
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	/*
	 * @GetMapping("/currency-exchange/from/{from}/to/{to}") public
	 * ResponseEntity<List<CurrencyExchange>> retrieveCurrencyExchange(@PathVariable
	 * String from,@PathVariable String to){
	 * 
	 * List<CurrencyExchange> currencyExchangeList =
	 * currencyExchangeRepository.findByFromAndTo(from,to); return new
	 * ResponseEntity<List<CurrencyExchange>>(currencyExchangeList, HttpStatus.OK);
	 * 
	 * 
	 * 
	 * CurrencyExchange currencyExchange = new CurrencyExchange();
	 * currencyExchange.setFrom(from); currencyExchange.setTo(to);
	 * 
	 * //currencyExchange.setId("60fbed384d23ec5962824abc");
	 * 
	 * Optional<CurrencyExchange> foundCurrencyExchange = currencyExchangeRepository
	 * .findOne(Example.of(currencyExchange));
	 * 
	 * 
	 * //Optional<CurrencyExchange> foundCurrencyExchange =
	 * currencyExchangeRepository.getCurrency(from, to);
	 * 
	 * if (foundCurrencyExchange != null && foundCurrencyExchange.isPresent()) {
	 * return new ResponseEntity<CurrencyExchange>(foundCurrencyExchange.get() ,
	 * HttpStatus.OK); } else { return new
	 * ResponseEntity<CurrencyExchange>(HttpStatus.NOT_FOUND); }
	 * 
	 * 
	 * 
	 * List<CurrencyExchange> list =currencyExchangeRepository.findAll(); return new
	 * ResponseEntity<CurrencyExchange>(list,HttpStatus.OK);
	 * 
	 * }
	 */

	@GetMapping("/currency-exchange/from_currency_code/{from_currency_code}/to_currency_code/{to_currency_code}")
	public ResponseEntity<CurrencyExchange> retrieveCurrencyExchange(@PathVariable(name="from_currency_code",required=true) @CurrencyCodeConstraint String from,
			@PathVariable(name="to_currency_code",required=true) @CurrencyCodeConstraint String to) throws CurrencyCodesEqualException {		
		return new ResponseEntity<CurrencyExchange>(currencyExchangeService.findLatestRecordByFromAndTo(from.toUpperCase(), to.toUpperCase()), HttpStatus.OK);
	}

}
