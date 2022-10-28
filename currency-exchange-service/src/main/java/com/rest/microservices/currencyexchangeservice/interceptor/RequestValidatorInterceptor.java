package com.rest.microservices.currencyexchangeservice.interceptor;

import com.rest.microservices.currencyexchangeservice.config.AppLogger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class RequestValidatorInterceptor implements HandlerInterceptor {

    private static final AppLogger LOGGER = AppLogger.getLogger(RequestValidatorInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        HandlerMethod method = (HandlerMethod) handler;
        parameterMap.forEach((key,value)->{
            LOGGER.info("Key: [ {} ] -> Value: [ {} ] ",key,value[0]);
        });

        RequestMapping mapping = method.getMethodAnnotation(RequestMapping.class);
        for (RequestMethod reqMethod : mapping.method()) {
            LOGGER.info("Request Method [ {} ]",reqMethod);
        }
        return true;
    }
}

