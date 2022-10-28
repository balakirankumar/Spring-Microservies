package com.rest.microservices.currencyexchangeservice.repository;

import com.rest.microservices.currencyexchangeservice.domain.CurrencyExchange;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchange,String> {

    CurrencyExchange findByFromAndTo(String from, String to);

}
