package com.neol.java.finalthreads.lifecycle.terminated;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
        });
        t.start();
        t.join();
        System.out.println(t.getState()); // TERMINATED

    }
}
