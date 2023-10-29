package com.neol.security.controllers;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

    @GetMapping(value = "/demo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> demo(){
        Mono<SecurityContext> context = ReactiveSecurityContextHolder.getContext();
        context.map(SecurityContext::getAuthentication)
                .log()
                .subscribe( authentication -> System.out.println(authentication.getAuthorities()));
        return Mono.just("Hello from demo");
    }

    @GetMapping(value = "/hello", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> hello(){
        return Mono.just("Hello from hello");
    }

}
