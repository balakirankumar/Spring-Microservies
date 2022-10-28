package com.rest.microservices.currencyexchangeservice.controller;

public final class ControllerMappings {

    public static final String CONTEXT_PATH = "/exchange-services";

    public static final String CURRENCY_EXCHANGE = CONTEXT_PATH + "/currency-exchange/from/{from}/to/{to}";

    public static final String CIRCUIT_BREAKER = CONTEXT_PATH + "/currency-exchange/circuit-breaker";

}
