package com.microservice.currencyconversionservice.controller;

import com.microservice.currencyconversionservice.domain.CurrencyConversion;
import com.microservice.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

  @Autowired
  public CurrencyExchangeProxy proxy;

  @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion calculate(
      @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

    ResponseEntity<CurrencyConversion> responseEntity =
        new RestTemplate()
            .getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, from, to);

    CurrencyConversion conversion = responseEntity.getBody();
    return new CurrencyConversion(
        conversion.getId(),
        from,
        to,
        conversion.getConversionMultiple(),
        quantity,
        quantity.multiply(conversion.getConversionMultiple()),
        conversion.getEnvironment());
  }

  @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion calculateWithFeign(
          @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

    CurrencyConversion conversion = proxy.getExchangeRate(from, to);

    return new CurrencyConversion(
            conversion.getId(),
            from,
            to,
            conversion.getConversionMultiple(),
            quantity,
            quantity.multiply(conversion.getConversionMultiple()),
            conversion.getEnvironment());
  }
}
