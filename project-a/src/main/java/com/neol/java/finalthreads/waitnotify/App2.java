package com.neol.java.finalthreads.waitnotify;

public class App2 {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();

        Thread t1 = new Thread(() -> {
           synchronized (lock){
               System.out.println(Thread.currentThread().getName() + " Starting Work A");
               System.out.println(Thread.currentThread().getName() + " Finishing Work A");
               try {
                   lock.wait();
                   lock.notify();
                   System.out.println(Thread.currentThread().getName() + " Starting Work B");
                   System.out.println(Thread.currentThread().getName() + " Finishing Work B");
                   lock.wait();
                   lock.notify();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " Starting Work A");
                System.out.println(Thread.currentThread().getName() + " Finishing Work A");
                try {
                    lock.notify();
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " Starting Work B");
                    System.out.println(Thread.currentThread().getName() + " Finishing Work B");
                    lock.notify();
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
