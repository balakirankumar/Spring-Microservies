package com.rest.microservices.currencyexchangeservice.service.impl;

import com.rest.microservices.currencyexchangeservice.config.AppLogger;
import com.rest.microservices.currencyexchangeservice.domain.CurrencyExchange;
import com.rest.microservices.currencyexchangeservice.exception.constants.StatusCode;
import com.rest.microservices.currencyexchangeservice.exception.exceptions.NotFoundException;
import com.rest.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CurrencyExchangeServiceImpl extends BeanInjectionService implements CurrencyExchangeService {

    private static final AppLogger LOGGER = AppLogger.getLogger(CurrencyExchangeServiceImpl.class);


    @Override
    public com.rest.microservices.currencyexchangeservice.mediatype.CurrencyExchange getByFromAndTo(String from, String to){
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if(Objects.isNull(currencyExchange)){
            LOGGER.error("Request received to get exchange value from [ {} ] to [ {} ] was not found", from,to);
            throw new NotFoundException(StatusCode._404.getDescription(),
                    String.format("Unable to find Data with from [ %s] and to [ %s ] ",from,to));
        }
        LOGGER.info("Request received to get exchange value from [ {} ] to [ {} ] was found of {}", from,to, currencyExchange);
        return getMediaType(currencyExchange);
    }

    private com.rest.microservices.currencyexchangeservice.mediatype.CurrencyExchange getMediaType(CurrencyExchange currencyExchangeDomain){
        com.rest.microservices.currencyexchangeservice.mediatype.CurrencyExchange currencyExchangeMedia
                = new com.rest.microservices.currencyexchangeservice.mediatype.CurrencyExchange();
        BeanUtils.copyProperties(currencyExchangeDomain,currencyExchangeMedia);
        return currencyExchangeMedia;
    }

}