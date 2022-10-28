package com.rest.microservices.limitsservices.controller;


import com.rest.microservices.limitsservices.mediatype.Limit;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ControllerMappping.limits)
public class LimitsController extends BaseController{


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Limit retrieveLimits() {
        return new Limit(configuration.getMinimum(), configuration.getMaximum());
//        return new Limit(1,1000);
    }

}
