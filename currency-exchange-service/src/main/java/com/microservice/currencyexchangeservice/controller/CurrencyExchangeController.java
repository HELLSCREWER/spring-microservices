package com.microservice.currencyexchangeservice.controller;

import com.microservice.currencyexchangeservice.domain.ExchangeValue;
import com.microservice.currencyexchangeservice.repository.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment env;

    @Autowired
    private ExchangeValueRepository repo;

    Logger LOG = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
        LOG.info("getExchangeValue() -> getting exchangeValue from: {}, to: {}", from, to);
        var exchangeValue = repo.getExchangeValue(from, to);
        exchangeValue.setEnvironment(env.getProperty("server.port"));
        LOG.info("getExchangeValue() -> fetched exchangeValue from: {}, to: {}; ev: {}", from, to, exchangeValue);
        return exchangeValue;
    }
}
