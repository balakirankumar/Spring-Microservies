package com.rest.microservices.currencyexchangeservice.controller;

import com.rest.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import com.rest.microservices.currencyexchangeservice.service.impl.BeanInjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class BaseController extends BeanInjectionService {

    @Autowired
    public CurrencyExchangeService currencyExchangeService;

}
