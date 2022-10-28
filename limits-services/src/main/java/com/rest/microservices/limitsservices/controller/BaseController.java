package com.rest.microservices.limitsservices.controller;

import com.rest.microservices.limitsservices.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    public Configuration configuration;
}
