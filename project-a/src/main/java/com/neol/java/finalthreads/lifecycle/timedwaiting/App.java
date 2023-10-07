package com.neol.java.finalthreads.lifecycle.timedwaiting;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        Thread.sleep(1000); // TIMED_WAITING
        System.out.println(t1.getState());

    }
}
