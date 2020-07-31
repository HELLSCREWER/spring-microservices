package com.microservice.limitService.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@ConfigurationProperties(prefix="limits.service")
public class Configuration {

    @Getter
    @Setter
    int maximum;

    @Getter @Setter
    int minimum;
}
