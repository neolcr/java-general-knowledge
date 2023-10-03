package com.neol.java.threads.geekfic.scheduler;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        scheduleWithFixedDelay();
    }

    public static void scheduledExecutorService() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Executing " + Thread.currentThread().getName());

        ScheduledFuture<?> future = scheduledExecutorService.schedule(task, 3, TimeUnit.SECONDS);
        System.out.printf("Remaining delay %sms%n", future.getDelay(TimeUnit.MILLISECONDS));
        TimeUnit.SECONDS.sleep(10);
        System.out.printf("Remaining delay %sms%n", future.getDelay(TimeUnit.MILLISECONDS));


        if (!scheduledExecutorService.awaitTermination(3, TimeUnit.SECONDS)){
            scheduledExecutorService.shutdown();
            System.out.println("End");
        }

    }

    public static void periodicExecution() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Executing: " + Thread.currentThread().getName());
        executor.scheduleAtFixedRate(task, 5, 1, TimeUnit.SECONDS);

        if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
            executor.shutdownNow();
            System.out.println("End");
        }
    }


    public static void scheduleWithFixedDelay() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Executing: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.err.println("Task interrupted");
            }

        };
//        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);// starts when the last finished

        if (!executor.awaitTermination(5, TimeUnit.MINUTES)){
            executor.shutdownNow();
            System.out.println("End");
        }

    }
}
