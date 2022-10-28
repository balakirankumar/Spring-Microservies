package com.rest.microservices.currencyexchangeservice.service.impl;


import com.rest.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class BeanInjectionService {

    @Autowired
    public Environment environment;

    @Autowired
    public CurrencyExchangeRepository currencyExchangeRepository;

}
