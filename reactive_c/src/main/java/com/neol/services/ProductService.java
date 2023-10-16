package com.neol.services;

import com.neol.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class ProductService {

    public Flux<Product> getAll(){
        var p1 = new Product();
        p1.setName("Beer");
        var p2 = new Product();
        p2.setName("Chocolate");
        Flux<Product> products = Flux.fromStream(Stream.of(p1, p2))
                .delayElements(Duration.ofSeconds(3));
        return products;
    }
}
