package com.microservice.currencyexchangeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@Document(collection="exchangeValue")
public class ExchangeValue {

    @Getter @Setter
    @Id
    private BigInteger id;

    @Getter @Setter
    private int port;

    @Getter @Setter
    @Field("currencyTo")
    private String to;

    @Getter @Setter
    @Field("currencyFrom")
    private String from;

    @Getter @Setter
    private BigDecimal conversionMultiple;
}
