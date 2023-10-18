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
                    System.out.println("All: Subscribed product: " + product.getName());
                });

        productService.getAll1().subscribe(product -> System.out.println("All1: subscribed product: " + product.getName()));

        productService.getAll2().subscribe(product -> System.out.println("All2: subscribed product: " + product.getName()));

    }
}
