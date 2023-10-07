package com.neol.java.finalthreads.lifecycle.waiting;

public class App {
    static Thread t1 = null;
    public static void main(String[] args) throws InterruptedException {
        t1 = new Thread(() -> {
            Thread t2 = new Thread(() -> System.out.println(t1.getState())); // T1 IS WAITING FOR T2 to finish
            t2.start();
            try {
                t2.join(); // JOIN MAKES IT TO BE WAITING;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        t1.start();
    }
}
