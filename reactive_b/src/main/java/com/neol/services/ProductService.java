package com.neol.services;

import com.neol.model.Product;
import com.neol.repositories.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService {

    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public Flux<Product> getProducts(){
        return repository.findAll()
                .delayElements(Duration.ofSeconds(5)); // for any element add a sleep duration
    }
}
