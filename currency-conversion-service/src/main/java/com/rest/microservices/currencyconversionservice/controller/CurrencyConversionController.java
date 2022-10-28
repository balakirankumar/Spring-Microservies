package com.rest.microservices.currencyconversionservice.controller;

import com.rest.microservices.currencyconversionservice.config.AppLogger;
import com.rest.microservices.currencyconversionservice.mediatype.CurrencyConversion;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping(value = ControllerMappings.CURRENCY_CONVERSION)
public class CurrencyConversionController extends BaseController{

    private static final AppLogger LOGGER = AppLogger.getLogger(CurrencyConversionController.class);

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
                                                          @PathVariable int quantity){

        LOGGER.info("Request received to get conversion value from [ {} ] to [ {} ] of quantity [ {} ] using Rest Template",
                from,to,quantity);
        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversion>  currencyConversionResponseEntity=new RestTemplate()
                .getForEntity("http://localhost:8000/exchange-services/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversion.class,uriVariables);
        CurrencyConversion currencyConversion = currencyConversionResponseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(),from,to,currencyConversion.getConversionMultiple(),quantity,currencyConversion.getConversionMultiple()*quantity,"");

    }

    @RequestMapping(method = RequestMethod.POST,consumes = "application+v1/json",params = "type=feign")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
                                                          @PathVariable int quantity){

        LOGGER.info("Request received to get conversion value from [ {} ] to [ {} ] of quantity [ {} ] using feign",
                from,to,quantity);
        CurrencyConversion currencyConversion = currencyExchangeProxy.getExchangeValue(from,to);

        return new CurrencyConversion(currencyConversion.getId(),from,to,currencyConversion.getConversionMultiple(),
                quantity,currencyConversion.getConversionMultiple()*quantity,
                currencyConversion.getEnvironment());

    }


}
