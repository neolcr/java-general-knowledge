package com.explanation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import scala.Int;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DemoControllerB {

    @GetMapping(value = "/explanationb", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> explanationb(){
        Flux<String> f1 = Flux.just("AAA", "BB", "C", "DDDD", "AAA", "B", "BB", "AAA");
        return f1
//                .filter(s -> s.length() % 2 == 0)
//                .log()
//                .distinct()
//                .distinctUntilChanged()
//                .map(String::length)
                .flatMap(s -> Flux.just(s.split("")));
    }

    @GetMapping(value = "/flatmap", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> flatmap(){
        Flux<Flux<Integer>> f1 = Flux.just(
          Flux.just(1,2,3),
          Flux.just(3,4,5, 5),
          Flux.just(3,4,5,6)
        );

        return f1.flatMap(i -> i);
    }

    @GetMapping(value = "/monolist", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<List<Integer>> monolist(){
        Flux<Flux<Integer>> f1 = Flux.just(
                Flux.just(1,2,3),
                Flux.just(3,4,5, 5),
                Flux.just(3,4,5,6)
        );

        return f1.flatMap(i -> i).collect(Collectors.toList());
    }


    @GetMapping(value = "/merge", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> merge(){
        Flux<String> f1 = Flux.just("AAA", "BB", "C", "DDDD", "AAA", "B", "BB", "AAA");
        Flux<String> f2 = Flux.just("sss", "33", "ds", "sdfs", "ii", "ddđdd", "ddddasdfadff");

        return f1
//                .concatWith(f2); // both
//                .thenMany(f2); // only f2
                .zipWith(f2, (a,b) -> a + ":" + b);
    }
}
