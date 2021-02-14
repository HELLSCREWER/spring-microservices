package com.microservice.currencyexchangeservice.controller;

import com.microservice.currencyexchangeservice.domain.ExchangeValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to){
        return new ExchangeValue(100l, from, to, BigDecimal.valueOf(100));
    }
}
