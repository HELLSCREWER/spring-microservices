package com.microservice.currencyexchangeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
public class ExchangeValue {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String to;

    @Getter @Setter
    private String from;

    @Getter @Setter
    private BigDecimal conversionMultiple;
}
