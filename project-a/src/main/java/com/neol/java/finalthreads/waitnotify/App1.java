package com.neol.java.finalthreads.waitnotify;

import java.util.concurrent.atomic.AtomicInteger;

public class App1 {
    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        AtomicInteger repetitions = new AtomicInteger();
        int timeToWait = 5000;
        int top = 5;
        Thread t1 = new Thread(() -> {
            while(repetitions.intValue() <  top){
                synchronized (monitor){
                    try {
                        System.out.println(Thread.currentThread().getName() + " Starting work...");
                        //Thread.sleep(timeToWait);
                        repetitions.getAndIncrement();
                        System.out.println(Thread.currentThread().getName() + " finished work -> going to wait...");
                        monitor.wait();
                        System.out.println(Thread.currentThread().getName() + " wakes up");
                        monitor.notify();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });

        Thread t2 = new Thread(() -> {
            while(repetitions.intValue() <  top){
                synchronized (monitor){
                    try {
                        System.out.println(Thread.currentThread().getName() + " Starting work...");
                        //Thread.sleep(timeToWait);
                        repetitions.getAndIncrement();
                        System.out.println(Thread.currentThread().getName() + " finished work -> going to wait...");
                        monitor.notify();
                        monitor.wait();
                        System.out.println(Thread.currentThread().getName() + " wakes up");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("End: repetitions: "  + repetitions.intValue());
    }
}
