package com.microservice.limitService.controllers;

import com.microservice.limitService.bean.LimitConfiguration;
import com.microservice.limitService.bean.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    Configuration config;

    @GetMapping("/limits")
    public LimitConfiguration getLimitConfigs(){
        return new LimitConfiguration(config.getMaximum(), config.getMinimum());
    };

}