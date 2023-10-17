package com.server.service;

import com.neol.commons.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class ProductService {
    public Flux<Product> getAll(){
        // Fake data
        return Flux.fromStream(
                Stream.of(
                        new Product("Beer"),
                        new Product("Chocolate"),
                        new Product("Wine"),
                        new Product("Pasta")
                )).delayElements(Duration.ofSeconds(5));
    }
}
