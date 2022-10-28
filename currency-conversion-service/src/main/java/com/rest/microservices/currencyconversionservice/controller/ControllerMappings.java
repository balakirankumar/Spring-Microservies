package com.rest.microservices.currencyconversionservice.controller;

public final class ControllerMappings {

    public static final String CONVERSION_CONTEXT_PATH = "/conversion-services";

    public static final String CURRENCY_CONVERSION = CONVERSION_CONTEXT_PATH + "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}";


    // For rest template used in controller to hit directly to 1 instance
    public static final String EXCHANGE_CONTEXT_PATH = "/exchange-services";

    public static final String CURRENCY_EXCHANGE = EXCHANGE_CONTEXT_PATH +"/currency-exchange/from/{from}/to/{to}";
}
