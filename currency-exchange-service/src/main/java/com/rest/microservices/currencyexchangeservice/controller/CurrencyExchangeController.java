package com.rest.microservices.currencyexchangeservice.controller;


import com.rest.microservices.currencyexchangeservice.config.AppLogger;
import com.rest.microservices.currencyexchangeservice.mediatype.CurrencyExchange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController()
@RequestMapping(value =ControllerMappings.CURRENCY_EXCHANGE)
public class CurrencyExchangeController extends BaseController{

    private static final AppLogger LOGGER = AppLogger.getLogger(CurrencyExchangeController.class);


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<CurrencyExchange> getExchangeValue(@PathVariable String from, @PathVariable String to){
//        CurrencyExchange currencyExchange = new CurrencyExchange(UUID.randomUUID().toString(),from,to,79);
        LOGGER.info("Request received to get value exchange from [ {} ] to [ {} ]",from,to);
        CurrencyExchange currencyExchange = currencyExchangeService.getByFromAndTo(from, to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
    }
}
