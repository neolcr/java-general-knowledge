package com.neol.java.versions;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8NewFeatures {
    public static void main(String[] args) {
        showJava8News();
    }

    @FunctionalInterface
    interface MyFunctionalInterface{
        void doSomething(int a, int b);
    }

    interface WithDefaultAndStatic{
        default void withBody(){
            System.out.println("Default method from interface");
        }
        default void withBody2(){
            System.out.println("Default method2 from interface");
        }
        static void withStatic(){
            System.out.println("Static from interface");
        }
    }

    static class WithDefaultAndStaticImpl implements WithDefaultAndStatic{
        @Override
        public void withBody() {
            System.out.println("Default from implementor");
        }
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

        // 4 Interfaces with default (foreach is default in Iterable) and static methods
        WithDefaultAndStaticImpl withDefaultAndStatic = new WithDefaultAndStaticImpl();
        withDefaultAndStatic.withBody();
        withDefaultAndStatic.withBody2();
        WithDefaultAndStatic.withStatic();

        // 5 Time API
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        Instant instant = Instant.now();

        // 6 Bulk Data Operations: stream() and parallelStream()
        List<Integer> nums = new ArrayList<>();
        IntStream.range(0, 100).forEach(nums::add);
        Stream<Integer> sequentialList = nums.stream();
        Stream<Integer> parallelList = nums.parallelStream();
        sequentialList.filter(n -> n > 90).forEach(n -> System.out.println("Sequential: "+ n));
        parallelList.filter(n -> n > 90).forEach(n -> System.out.println("Parallel: "+ n));

        // 7 Optional
        Optional<String> optional = Optional.empty();
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());

        // 8 Reactive Streams (java.util.concurrent.Flow)
        // Create example in package reactive


    }
}
