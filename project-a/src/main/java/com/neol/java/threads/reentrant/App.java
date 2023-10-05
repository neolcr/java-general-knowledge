package com.neol.java.threads.reentrant;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class App {
    private static int count = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition cond = lock.newCondition();

    private static void increment(){
        IntStream.range(0, 10_000).forEach(i -> {
            count++;
        });
    }

    private static void finished(){
        System.out.println("Count is: " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Waiting....");
                cond.await();
                System.out.println("Woken up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                increment();
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            System.out.println("Press the return key");
            new Scanner(System.in).nextLine();
            System.out.println("Got return key");
            cond.signal();

            try{
                increment();
            }finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        finished();


    }
}
