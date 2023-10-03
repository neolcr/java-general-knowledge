package com.neol.java.threads.geekfic.invokeAll;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Run {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
            () -> "Test 1", () -> "Test 2", () -> "Test 3",
            () -> "Test 4", () -> "Test 5", () -> "Test 6"
        );

        for(Future<String> future : executorService.invokeAll(callables)){
            System.out.println(future.get());
        }
    }
}
