package com.rest.microservices.apigateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/get")
                                .filters(f -> f.addRequestHeader("MyHeader","SECRET")
                                                .addRequestParameter("MyParam","NOTSECRET"))
                                .uri("http://httpbin.org:80"))

                .route(p -> p.path("/conversion-services/**")
                        .filters(f -> f.addRequestHeader("Content-Type","application+v1/json")
                                .addRequestParameter("type","feign"))
                        .uri("lb://currency-conversion"))

                .route(p -> p.path("/conversion-services-rewrite/**")
                        .filters(f -> f.rewritePath("/conversion-services-rewrite/(?<segment>.*)","/conversion-services/${segment}")
                                .addRequestHeader("Content-Type","application+v1/json"))
                        .uri("lb://currency-conversion"))

                .route(p -> p.path("/exchange-services/**")
                        .uri("lb://currency-exchange"))
                .build();

//        return routeLocatorBuilder.routes().build();
    }
}
