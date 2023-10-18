package com.client.proxy;

import com.client.exceptions.ProductRetreiveException;
import com.neol.commons.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Component
public class ProductProxy {
    private final WebClient webClient;

    public ProductProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    // Turn off the server to see exception behaviour
    public Flux<Product> getAll(){
        return webClient.get()
                .uri("/products")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class))
//                .onErrorResume(e -> Flux.just(new Product("Default"))); // any exception, not recommended
//                .onErrorReturn(new Product("Default")); // any exception, not recommended
//                .onErrorMap(e -> new ProductRetreiveException(e.getMessage()));
                // the following doOnNext is used to explain .onErrorContinue
                .doOnNext(p -> {
                    if (p.getName().isEmpty())throw new ProductRetreiveException("Empty name");
                })
                .onErrorContinue((exception, objectCausedException) -> System.out.println(exception.getMessage()));
//                .retry(3);


    }

    public Flux<Product> getAll1() {
        return webClient.get()
                .uri("/products1")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class))
                //specify WebClientRequestException (for instance)
//                .onErrorResume(WebClientRequestException.class, e -> Flux.just(new Product("Default")));
//                .onErrorReturn(WebClientRequestException.class, new Product("Default"));
                // the following doOnNext is used to explain .onErrorContinue
                .doOnNext(p -> {
                    if (p.getName().isEmpty())throw new ProductRetreiveException("Empty name");
                })
                  .onErrorContinue(ProductRetreiveException.class, (exception, objectCausedException) -> System.out.println(exception.getMessage()));
//                .retry(3);
    }

    public Flux<Product> getAll2() {
        return webClient.get()
                .uri("/products")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class))
                // predicate (condition)
//                .onErrorResume(e -> !e.getMessage().isEmpty(), e -> Flux.just(new Product("Default")));
//                .onErrorReturn(e -> !e.getMessage().isEmpty(), new Product("Default"));
                // the following doOnNext is used to explain .onErrorContinue
                .doOnNext(p -> {
                    if (p.getName().isEmpty())throw new ProductRetreiveException("Empty name");
                })
                .onErrorContinue(e -> !e.getMessage().isEmpty(), (exception, objectCausedException) -> System.out.println(exception.getMessage()));
//                .retry(3);

    }
}
