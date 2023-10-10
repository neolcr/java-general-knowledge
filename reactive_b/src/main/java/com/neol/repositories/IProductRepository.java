package com.neol.repositories;

import com.neol.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
