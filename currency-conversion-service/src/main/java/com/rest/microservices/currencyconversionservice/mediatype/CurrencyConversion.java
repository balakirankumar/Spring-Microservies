package com.rest.microservices.currencyconversionservice.mediatype;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {

    private String id;
    private String from;
    private String to;
    private float conversionMultiple;
    private int quantity;
    private float totalCalculatedAmount;
    private String environment;
}
