package com.neol.java.threads.future;

import java.util.concurrent.CompletableFuture;

public class FutureExample {
    public static void main(String[] args) {
        // Create a CompletableFuture for an asynchronous task
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a time-consuming task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return 42;
        });

        // Continue with other work while the task is running
        System.out.println("Do some other work...");

        // Retrieve the result from the future when needed
        try {
            int result = future.get(); // Blocking call
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
