package com.tomaszplonski.TabletopPlatform.ApiGateway;


import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;

import java.util.Set;

@Component
public class PathAndHeadersPreFilter implements GlobalFilter {

    final Logger logger = LoggerFactory.getLogger(PathAndHeadersPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String id = exchange.getRequest().getId();

        String requestPath = exchange.getRequest().getPath().toString();
        logger.info(id + "|=> Request path = " + requestPath);

        HttpHeaders headers = exchange.getRequest().getHeaders();
        Set<String> headerNames = headers.keySet();

        headerNames.forEach((headerName)-> {
            String headValue = headers.getFirst(headerName);
            logger.info(id + "|=> " + headerName + " " + headValue);
            });


        return chain.filter(exchange);
    }
}
