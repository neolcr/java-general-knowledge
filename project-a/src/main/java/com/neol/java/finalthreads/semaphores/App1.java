package com.neol.java.finalthreads.semaphores;

import java.util.concurrent.Semaphore;

public class App1 {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphoreA = new Semaphore(1);
        final Semaphore semaphoreB = new Semaphore(0);
        final Semaphore semaphoreC = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            try {
                semaphoreA.acquire();
                System.out.println(Thread.currentThread().getName() + " starting Work A");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finishing Work A");
                semaphoreB.release();
                semaphoreA.acquire();
                System.out.println(Thread.currentThread().getName() + " starting Work B");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finishing Work B");
                semaphoreB.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                semaphoreB.acquire();
                System.out.println(Thread.currentThread().getName() + " starting Work A");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finishing Work A");
                semaphoreC.release();
                semaphoreB.acquire();
                System.out.println(Thread.currentThread().getName() + " starting Work B");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finishing Work B");
                semaphoreC.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                semaphoreC.acquire();
                System.out.println(Thread.currentThread().getName() + " starting Work A");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finishing Work A");
                semaphoreA.release();
                semaphoreC.acquire();
                System.out.println(Thread.currentThread().getName() + " starting Work B");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finishing Work B");
                semaphoreA.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
