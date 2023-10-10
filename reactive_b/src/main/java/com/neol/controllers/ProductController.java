package com.neol.controllers;

import com.neol.model.Product;
import com.neol.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProduct(){
        return service.getProducts();
    }
}
