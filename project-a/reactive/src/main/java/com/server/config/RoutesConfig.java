package com.server.config;

import com.server.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutesConfig {
    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler){
        return route()
                .GET("/products", productHandler::getAll)
                .build();
    }
}
