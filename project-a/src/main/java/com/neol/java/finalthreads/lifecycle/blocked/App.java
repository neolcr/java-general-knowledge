package com.neol.java.finalthreads.lifecycle.blocked;

public class App {
    public static void main(String[] args) throws InterruptedException {
        final Object monitor = new Object();
        Thread t1 = new Thread(() -> {
           synchronized (monitor){
               while (true){

               }
           }
        });
        Thread t2 = new Thread(() -> {
            synchronized (monitor){
                while (true){

                }
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(1000);

        System.out.println(t2.getState()); // BLOCKED
        System.exit(0);
    }
}
