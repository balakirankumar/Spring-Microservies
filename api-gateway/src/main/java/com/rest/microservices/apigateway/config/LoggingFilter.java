package com.rest.microservices.apigateway.config;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

    private static final AppLogger LOGGER = AppLogger.getLogger(LoggingFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info("Path of the request -> [ {}?{} ]",exchange.getRequest().getPath(),
                exchange.getRequest().getQueryParams().toString());

        return chain.filter(exchange);
    }
}
