package com.rest.microservices.currencyexchangeservice.controller;

import com.rest.microservices.currencyexchangeservice.config.AppLogger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = ControllerMappings.CIRCUIT_BREAKER)
public class CircuitBreakerController {
    private static final AppLogger LOGGER = AppLogger.getLogger(CircuitBreakerController.class);

    @GetMapping
//    @Retry(name = "sample-api",fallbackMethod = "hardCodedResponse")
//    @CircuitBreaker(name = "default",fallbackMethod = "hardCodedResponse")
//    @RateLimiter(name = "default",fallbackMethod =  "hardCodedResponse")
    public String sampleApi(){
        LOGGER.info("Sample Api called");
//        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/dummy", String.class);
        return "Sample Api";
    }

    public String hardCodedResponse(Exception ex){
        return "FallBack Response "+ex.toString();
    }
}
