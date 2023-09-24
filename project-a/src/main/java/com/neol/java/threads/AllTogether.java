package com.neol.java.threads;

import java.util.concurrent.*;

public class AllTogether {
    public static void main(String[] args) {
        // Create a thread pool executor with a fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to the executor, which return Futures
        Future<Integer> future1 = executor.submit(() -> {
            Thread.sleep(10000);
            // Perform some computation
            return 42;
        });

        Future<Integer> future2 = executor.submit(() -> {
            // Perform another computation
            return 100;
        });

        // Use Futures to retrieve the results when needed
        try {
            int result1 = future1.get();
            int result2 = future2.get();
            System.out.println("Result1: " + result1);
            System.out.println("Result2: " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the executor when done
        executor.shutdown();
    }
}
