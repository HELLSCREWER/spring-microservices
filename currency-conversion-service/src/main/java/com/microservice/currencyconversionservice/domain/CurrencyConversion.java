package com.microservice.currencyconversionservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
public class CurrencyConversion {

    @Id
    private BigInteger id;

    @NonNull
    private String from;

    @NonNull
    private String to;

    private BigDecimal conversionMultiple;

    @NonNull
    private BigDecimal quantity;

    @NonNull
    private BigDecimal totalCalculatedAmount;

    private String environment;

//    public CurrencyConversion(long id, @NonNull String from, @NonNull String to, BigDecimal conversionMultiple, @NonNull BigDecimal quantity, @NonNull BigDecimal totalCalculatedAmount, String environment) {
//        this.id = id;
//        this.from = from;
//        this.to = to;
//        this.conversionMultiple = conversionMultiple;
//        this.quantity = quantity;
//        this.totalCalculatedAmount = totalCalculatedAmount;
//        this.environment = environment;
//    }
}
