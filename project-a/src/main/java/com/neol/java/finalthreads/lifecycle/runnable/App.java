package com.neol.java.finalthreads.lifecycle.runnable;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Inside thread: " + Thread.currentThread().getState());
        });
        t.start();
        System.out.println("Outside thread: " + t.getState());
    }
}
