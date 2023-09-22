package com.neol.java.versions;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJavaVersions {
    public static void main(String[] args) {
        showJava8News();
    }

    @FunctionalInterface
    interface MyFunctionalInterface{
        void doSomething(int a, int b);
    }

    private static void showJava8News() {
        // 0 Method reference :: && Foreach in Iterable
        Arrays.asList(1,2,3).forEach(System.out::println);
        // 1 Lamba expressions
        Thread thread = new Thread(() -> System.out.println("inside thread"));
        thread.start();
        // 2 Functional interfaces
        MyFunctionalInterface myFunctionalInterface = (a, b) -> System.out.println("Result of functional interface: " + (a + b));
        myFunctionalInterface.doSomething(3,4);
        // 3 Stream API
        Stream.of(1,2,3,4)
                .map(n -> n * 2)
                .filter(n -> n > 5)
                .collect(Collectors.toList())
                .forEach(n -> myFunctionalInterface.doSomething(n, n));



    }
}
