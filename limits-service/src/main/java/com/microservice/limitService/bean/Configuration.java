package com.microservice.limitService.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@EnableConfigurationProperties
@ConfigurationProperties("limits-service")
@PropertySource("bootstrap.properties")
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {

    private int maximum;
    private int minimum;

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

//    public Configuration(int maximum, int minimum) {
//        this.maximum = maximum;
//        this.minimum = minimum;
//    }
//
//    public Configuration() {
//    }
}
