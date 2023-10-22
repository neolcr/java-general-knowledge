package com.explanation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Caller implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "merge";
        System.out.println("Calling endpoint................................");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8883/" + endpoint, String.class);
        System.out.println(forEntity.getBody());
        System.out.println("Got response from endpoint " + forEntity.getStatusCode() + "................................");
    }
}
