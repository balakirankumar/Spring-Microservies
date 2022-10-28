package com.rest.microservices.currencyexchangeservice.service;

import com.rest.microservices.currencyexchangeservice.mediatype.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange getByFromAndTo(String from, String to);


}
