package com.project.currencyexchangeservice.resource;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="currency_exchange")
public class CurrencyExchange {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "from_name")
    private String from;
    @Column(name = "to_name")
    private String to;
    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;
}
