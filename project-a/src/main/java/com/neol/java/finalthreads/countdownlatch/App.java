package com.neol.java.finalthreads.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String ... args) throws InterruptedException {
        final CountDownLatch latchA = new CountDownLatch(1);
        final CountDownLatch latchB = new CountDownLatch(1);
        final CountDownLatch latchC = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
           try{
               System.out.println(Thread.currentThread().getName() + " starting Work A");
               Thread.sleep(5000);
               System.out.println(Thread.currentThread().getName() + " finishing Work A");
               latchA.countDown();

               latchB.await();
               System.out.println(Thread.currentThread().getName() + " starting Work B");
               Thread.sleep(5000);
               System.out.println(Thread.currentThread().getName() + " finishing Work B");
               latchC.countDown();

           }catch (InterruptedException e){
               System.err.println(e.getMessage());
           }
        });

        Thread t2 = new Thread(() -> {
            try{
                latchA.await();
                System.out.println(Thread.currentThread().getName() + " starting Work A");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finishing Work A");
                latchB.countDown();

                latchC.await();
                System.out.println(Thread.currentThread().getName() + " starting Work B");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " finishing Work B");
            }catch (InterruptedException e){
                System.err.println(e.getMessage());
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
