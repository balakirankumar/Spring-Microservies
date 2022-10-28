package com.rest.microservices.currencyexchangeservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class CurrencyExchange {

    @Id
    private String id;

    @NotNull
    @Column(name = "currency_from")
    private String from;

    @NotNull
    @Column(name = "currency_to")
    private String to;

    @NotNull
    private float conversionMultiple;

    private String environment;

    public CurrencyExchange(String id, String from, String to, float conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}