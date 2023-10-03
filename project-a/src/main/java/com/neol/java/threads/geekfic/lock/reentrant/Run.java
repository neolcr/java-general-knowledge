package com.neol.java.threads.geekfic.lock.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Run {
    static ReentrantLock lock = new ReentrantLock();
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        reentrantLockExample2();
    }

    private static void reentrantLockExample2() throws InterruptedException {
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService executor2 = Executors.newSingleThreadScheduledExecutor();

        executor1.submit(() -> {
            System.out.println(Thread.currentThread().getName());
           lock.lock();
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        executor2.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Locked " + lock.isLocked());
            System.out.println("Held by this thread: " + lock.isHeldByCurrentThread());
//            System.out.println("Hold count: " + lock.getHoldCount());
//            System.out.println("Queue length: " + lock.getQueueLength());
            System.out.println("Lock aquired: " + lock.tryLock());
            System.out.println("==============================================");
        }, 0, 2, TimeUnit.SECONDS);

        if (!executor1.awaitTermination(5, TimeUnit.SECONDS)){
            executor1.shutdownNow();
            executor2.shutdownNow();
        }


    }

    private static void reentrantLockExample1() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0, 1000)
                .forEach(i-> executor.submit(Run::increment));
        Thread.sleep(10_000);
        System.out.println(count);

        if (!executor.awaitTermination(12, TimeUnit.SECONDS)){
            executor.shutdownNow();
        }
    }

    static void increment(){
        System.out.println(Thread.currentThread().getName());
        lock.lock();
        try{
            count += 1;
        }finally {
            lock.unlock();
        }

    }
}

