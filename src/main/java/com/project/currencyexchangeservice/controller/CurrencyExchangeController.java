package com.project.currencyexchangeservice.controller;

import com.project.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.project.currencyexchangeservice.resource.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange byFromAndTo = currencyExchangeRepository.findByFromAndTo(from, to);
        return new ResponseEntity<>(byFromAndTo, HttpStatus.OK);
    }

}
