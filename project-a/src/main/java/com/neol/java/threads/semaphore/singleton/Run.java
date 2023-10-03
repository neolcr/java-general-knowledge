package com.neol.java.threads.semaphore.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Run {
    public static void main(String[] args) throws InterruptedException {


        ExecutorService executor = Executors.newCachedThreadPool();

        IntStream.range(0, 200).forEach(i -> {
            executor.submit(() -> {
                try {
                    Connection.getInstance().connect();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        if (!executor.awaitTermination(1, TimeUnit.HOURS)){
            executor.shutdownNow();
            System.out.println("Done");
        }
    }
}
