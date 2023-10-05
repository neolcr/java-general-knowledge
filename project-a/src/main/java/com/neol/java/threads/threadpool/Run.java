package com.neol.java.threads.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Run {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        IntStream.range(0,5).forEach(i -> executor.submit(new Processor(i)));

        executor.shutdown();
        System.out.println("All tasks submitted");
        try {
            executor.awaitTermination(4, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End");

    }
}


class Processor implements Runnable{

    private final int id;

    Processor(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed " + id);
    }
}