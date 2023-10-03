package com.neol.java.threads.geekfic.invokeAny;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Run {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
            newCallable("Task 1", 3),
            newCallable("Task 2", 2),
            // Will print this one as it the one firts to finish
            newCallable("Task 3", 1)
        );

        System.out.println(executorService.invokeAny(callables));
    }

    private static Callable<String> newCallable(String result, int sleepSec) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSec);
            return result;
        };
    }
}
