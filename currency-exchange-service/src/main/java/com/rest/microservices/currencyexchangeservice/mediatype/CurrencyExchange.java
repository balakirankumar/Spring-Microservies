package com.rest.microservices.currencyexchangeservice.mediatype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {

    private String id;
    private String from;
    private String to;
    private float conversionMultiple;
    private String environment;

    public CurrencyExchange(String id, String from, String to, float conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}