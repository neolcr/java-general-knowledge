package com.client.services;

import com.client.proxy.ProductProxy;
import com.neol.commons.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {
    private final ProductProxy productProxy;

    public ProductService(ProductProxy productProxy) {
        this.productProxy = productProxy;
    }

    public Flux<Product> getAll(){
        return productProxy.getAll();
    }
}
