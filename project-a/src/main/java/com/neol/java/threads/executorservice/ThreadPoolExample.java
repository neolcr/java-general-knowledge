package com.neol.java.threads.executorservice;

import org.junit.jupiter.api.Assertions;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;




public class ThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        scheduledThreadPoolExecutorRepeat();
    }

    private static void scheduledThreadPoolExecutorRepeat() throws InterruptedException {
        CountDownLatch lock = new CountDownLatch(3);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        ScheduledFuture<?> future = executorService.scheduleAtFixedRate(() -> {
            System.out.println("The execution");
        }, 500, 100, TimeUnit.MILLISECONDS);

        lock.await(1000, TimeUnit.MILLISECONDS);

//        future.cancel(true);
    }

    private static void scheduledThreadPoolExecutor() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.schedule(() -> System.out.println("This is me"), 5, TimeUnit.SECONDS);
    }

    private static void newSingleThreadExecutor(){
        AtomicInteger counter = new AtomicInteger();

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(()-> counter.set(1));

        service.submit(()->{
            counter.compareAndSet(1, 2);
        });

        System.out.println(counter);

        service.shutdown();
        try{
            if (!service.awaitTermination(5, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    private static void newCachedThreadPool() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        Assertions.assertEquals(3, executor.getPoolSize());
        Assertions.assertEquals(0, executor.getQueue().size());

    }

    private static void newFixedThreadPool() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);

        executor.submit(()->{
           Thread.sleep(1000);
           return null;
        });

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        executor.submit(()->{
            Thread.sleep(1000);
            return null;
        });

        Assertions.assertEquals(2, executor.getPoolSize());
        Assertions.assertEquals(17, executor.getQueue().size());
    }

    private static void executorUsingFuture() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Hello there");
        Thread.sleep(1000);
        String result = future.get();
        System.out.println(result);
    }

    // Single thread
    private static void executor() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("hello there"));
        // Does not control the termination of the thread
    }

    private static void executorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        IntStream.range(0, 4).forEach(i -> {
            executorService.submit(() -> {
                System.out.println("Task: " + i + " is running on thread "+ Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task: " + i + " is completed on thread "+ Thread.currentThread().getName());
            });
        });

        executorService.shutdown();
        try{
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
