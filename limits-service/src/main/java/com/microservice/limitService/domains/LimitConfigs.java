package com.microservice.limitService.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class LimitConfigs {

    @Getter @Setter
    int maximum;

    @Getter @Setter
    int minimum;

    public LimitConfigs(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }
}