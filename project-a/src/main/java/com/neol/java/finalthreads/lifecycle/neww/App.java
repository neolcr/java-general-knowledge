package com.neol.java.finalthreads.lifecycle.neww;

public class App {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
        });

        System.out.println(t.getState()); //NEW
    }
}
