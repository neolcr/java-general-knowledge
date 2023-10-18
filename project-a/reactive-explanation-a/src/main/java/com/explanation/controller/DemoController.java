package com.explanation.controller;

import com.explanation.subscribers.DemoSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo(){
        Flux<Integer> f1 = Flux.just(1, 2, 3, 4, 5, 6, 7);
        Flux<Integer> f2 = Flux.fromStream(Stream.of(1, 2, 3, 4, 5));
        Flux<Integer> f3 = Flux.fromIterable(List.of(1, 2, 3, 4, 5, 6));
        Mono<Integer> m1 = Mono.just(1);

        f1.doOnNext(System.out::println); // does nothing, there is no suscriber

//        f1.subscribe(n -> System.out.print(n + ","));

        f1.doOnNext(e -> {
            if (e == 2){
                throw new RuntimeException("not 2 is allowed");
            }
        }).subscribe(new DemoSubscriber());

        f1.subscribe(new DemoSubscriber());

    }
}
