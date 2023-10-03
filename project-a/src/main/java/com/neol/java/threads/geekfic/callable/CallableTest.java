package com.neol.java.threads.geekfic.callable;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws Exception {
        Callable<String> task = () -> {
            try{
                TimeUnit.SECONDS.sleep(4);
                return "Returning after sleeping for 4 seconds";
            }catch (InterruptedException ie){
                ie.printStackTrace();
                return null;
            }
        };

        Callable<String> task2 = () -> {
            try{
                TimeUnit.SECONDS.sleep(6);
                return "Returning after sleeping for 6 seconds";
            }catch (InterruptedException ie){
                ie.printStackTrace();
                return null;
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> future1 = executorService.submit(task);
        System.out.println("Future 1 is done: " + future1.isDone());
        TimeUnit.SECONDS.sleep(5);
        // Will be done
        System.out.println("Future 1 is done: " + future1.isDone());


        Future<String> future2 = executorService.submit(task2);
        System.out.println("Future 2 is done: " + future2.isDone());
        TimeUnit.SECONDS.sleep(5);
        // Won't be done
        System.out.println("Future 2 is done: " + future2.isDone());

        System.out.println(future1.get());
        System.out.println(future2.get());

        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)){
            executorService.shutdownNow();
            System.out.println("Shutdown finished");
        }
    }
}
