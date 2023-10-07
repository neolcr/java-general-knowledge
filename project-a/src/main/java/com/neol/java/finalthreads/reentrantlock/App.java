package com.neol.java.finalthreads.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        final Condition condA = lock.newCondition();
        final Condition condB = lock.newCondition();

        Thread t1 = new Thread(() -> {
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " Starting Work A");
                System.out.println(Thread.currentThread().getName() + " Finishing Work A");
                try {
                    condA.await();
                    condB.signal();
                    System.out.println(Thread.currentThread().getName() + " Starting Work B");
                    System.out.println(Thread.currentThread().getName() + " Finishing Work B");
                    condA.await();
                    condB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " Starting Work A");
                System.out.println(Thread.currentThread().getName() + " Finishing Work A");
                try {
                    condA.signal();
                    condB.await();

                    System.out.println(Thread.currentThread().getName() + " Starting Work B");
                    System.out.println(Thread.currentThread().getName() + " Finishing Work B");
                    condA.signal();
                    condB.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
