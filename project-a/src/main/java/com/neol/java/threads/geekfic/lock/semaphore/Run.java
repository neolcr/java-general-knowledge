package com.neol.java.threads.geekfic.lock.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Run {
    public static void main(String[] args) {
        semaphoreExample();
    }

    private static void semaphoreExample() {
        Semaphore semaphore = new Semaphore(6);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable task = () -> {
            boolean permit = false;
            try{
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit){
                    System.out.println("Semaphore acquired by thread: " + Thread.currentThread().getName());
                    Thread.sleep(5_000);
                }else{
                    System.out.println("Could not acquire semaphore -> thread: " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (permit){
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10).forEach(i -> executor.submit(task));

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdownNow();
                System.out.println("Done");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
