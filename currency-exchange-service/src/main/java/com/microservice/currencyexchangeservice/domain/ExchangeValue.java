package com.microservice.currencyexchangeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@Document(collection="exchangeValue")
@Data
public class ExchangeValue {

    @Id
    private BigInteger id;

    private int port;

    @Field("currencyTo")
    private String to;

    @Field("currencyFrom")
    private String from;

    private BigDecimal conversionMultiple;

    private String environment;
}
