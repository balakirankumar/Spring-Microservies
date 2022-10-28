package com.rest.microservices.currencyconversionservice.controller;

import com.rest.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    public CurrencyExchangeProxy currencyExchangeProxy;
}
