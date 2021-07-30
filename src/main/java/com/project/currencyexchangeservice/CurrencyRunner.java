package com.project.currencyexchangeservice;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.project.currencyexchangeservice.resource.CurrencyExchange;

@Component
public class CurrencyRunner implements CommandLineRunner{
	private MongoTemplate mongoTemplate;

    public CurrencyRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

    	CurrencyExchange currencyExchange = new CurrencyExchange();
		currencyExchange.setId("12345");
		currencyExchange.setFromCurrencyCode("GBP");
		currencyExchange.setToCurrencyCode("INR");
		currencyExchange.setExchangeRate(new BigDecimal(101.33));
		currencyExchange.setLastEvaluationDate(LocalDate.now());
        this.mongoTemplate.save(currencyExchange);

        System.out.println("Application started...");
    }
}
