package com.microservice.limitService.controllers;

import com.microservice.limitService.domains.LimitConfigs;
import com.microservice.limitService.domains.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    Configuration config;

    @GetMapping("/limits")
    public LimitConfigs getLimitConfigs(){
        return new LimitConfigs(config.getMaximum(), config.getMinimum());
    };

}