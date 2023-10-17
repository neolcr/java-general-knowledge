package com.client.runners;

import com.neol.commons.model.Product;
import com.client.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ProductRunner implements CommandLineRunner {

    private final ProductService productService;

    public ProductRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<Product> all = productService.getAll();
        all
//                .doOnNext(product -> {
//                    System.out.println(product.getName());
//                })
                .subscribe(product -> {
                    System.out.println("Subscribed product: " + product.getName());
                });

    }
}
