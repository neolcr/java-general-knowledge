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
                        new Product(""),
                        new Product("Beer"),
                        new Product("Chocolate"),
                        new Product("Wine"),
                        new Product("Pasta")
                )).delayElements(Duration.ofSeconds(5));
    }

    public Flux<Product> getAll1(){
        // Fake data
        return Flux.fromStream(
                Stream.of(
                        new Product("Whey"),
                        new Product("Milk"),
                        new Product(""),
                        new Product("Oat"),
                        new Product("Eggs")
                )).delayElements(Duration.ofSeconds(5));
    }

    public Flux<Product> getAll2(){
        // Fake data
        return Flux.fromStream(
                Stream.of(
                        new Product("Peanuts"),
                        new Product("Hazelnuts"),
                        new Product("Meat"),
                        new Product("Orange"),
                        new Product("Banana")
                )).delayElements(Duration.ofSeconds(5));
    }
}
