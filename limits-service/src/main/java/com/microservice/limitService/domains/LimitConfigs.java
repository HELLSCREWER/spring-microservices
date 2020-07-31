package com.microservice.limitService.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class LimitConfigs {

    @Getter @Setter
    int maximum;

    @Getter @Setter
    int minimum;
}