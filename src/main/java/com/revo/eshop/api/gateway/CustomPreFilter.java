package com.revo.eshop.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component
public class CustomPreFilter implements GlobalFilter, Ordered {
    final Logger logger = LoggerFactory.getLogger(CustomPreFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("First Custom pre-filter is executed");
        String requestPath = exchange.getRequest().getPath().toString();

        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        Set<String> headerNames = httpHeaders.keySet();
        exchange.getRequest(); // get validate JWT token and
        exchange.getRequest().getRemoteAddress().getHostName();
        // we could include remote address in jwt
        //
        headerNames.forEach((headerName) -> {
            String headerValue = httpHeaders.getFirst(headerName);
            logger.info(headerName + " - " + headerValue);
        });
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
