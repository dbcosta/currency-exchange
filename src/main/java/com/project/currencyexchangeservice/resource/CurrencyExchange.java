package com.project.currencyexchangeservice.resource;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("currency")
@Data
public class CurrencyExchange {

	@Id	
	private String id;
	private String fromCurrencyCode;
	private String toCurrencyCode;
	private BigDecimal exchangeRate;
	private LocalDate lastEvaluationDate;
		
}
