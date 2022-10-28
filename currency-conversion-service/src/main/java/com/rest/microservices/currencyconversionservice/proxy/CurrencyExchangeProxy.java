package com.rest.microservices.currencyconversionservice.proxy;


import com.rest.microservices.currencyconversionservice.controller.ControllerMappings;
import com.rest.microservices.currencyconversionservice.mediatype.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// application service name to be called
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @RequestMapping(method = RequestMethod.GET,value = ControllerMappings.CURRENCY_EXCHANGE)
    CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);

}
