package com.explanation.controller;

import com.explanation.publishers.DemoPublisher;
import com.explanation.subscribers.DemoSubscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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

        f1.log().subscribe(new DemoSubscriber());

    }

    @GetMapping("/custom")
    public void custom(){
        DemoPublisher publisher = new DemoPublisher(List.of(1, 2, 3, 4, 5, 6, 7 , 8));
        publisher.subscribe(new DemoSubscriber());

    }

    @GetMapping("/flux")
    public void flux(){
        int factor = 3;

        Flux<String> f1 = Flux.create(s -> {
            for(int i = 0; i <= 12 ; i++){
                //if (i == 2) s.error(new RuntimeException("I dont like the number 2"));
                s.next(xor(factor, i));
            }
            s.complete();
        });

        f1.log().subscribe(System.out::println);

    }


    @GetMapping("/log")
    public void log(){
        Flux<Integer> publisher = Flux.just(1,2,3,4,5);
        publisher.log().subscribe(System.out::println);

    }

    private String xor(int factor, int i) {
        return i + " | " + factor +" -> " +(i | factor) + "==" + Integer.toBinaryString(i | factor)
                + " (" + Integer.toBinaryString(i) + " | " + Integer.toBinaryString(factor) + ")";
    }
}
