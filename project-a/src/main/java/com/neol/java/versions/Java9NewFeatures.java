package com.neol.java.versions;

import com.neol.java.versions.api.Api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Java9NewFeatures {

    interface InterfaceWithPrivate{
        private String privateMethod(){
            return "Hello from private not static";
        }
        private static String privateStaticMethod(){
            InterfaceWithPrivate annonimous = new InterfaceWithPrivate() {
            };
            return annonimous.privateMethod();
        }
        default String defaultMethod(){
            return InterfaceWithPrivate.privateStaticMethod();
        }
    }
    static class InterfaceWithPrivateImpl implements InterfaceWithPrivate{

    }

    public static void main(String[] args) {
        // 0 Module System (project jigsaw)
        // module-info.java to define modules/packages and their dependencies
        Api api = new Api();
        System.out.println(api.getValue());

        // 1 Interface private & static private methods
        InterfaceWithPrivateImpl interfaceWithPrivate = new InterfaceWithPrivateImpl();
        System.out.println(interfaceWithPrivate.defaultMethod());

        // 2 New HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.boredapi.com/api/activity"))
                .GET()
                .build();
        CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        future.thenAccept( response -> {
            System.out.println(response.statusCode());
            System.out.println(response.body());
        });

        // wait for the response
        future.join();

        // 3 JShell
        // See example in cmd

        // 4 Optional to Stream
        List<Optional> listOfOptionals = Arrays.asList(Optional.empty(), Optional.of(""));
        listOfOptionals.stream()
                .filter(Optional::isPresent)
                .collect(Collectors.toList())
                .forEach(o -> System.out.println(o.isPresent()));



    }
}
