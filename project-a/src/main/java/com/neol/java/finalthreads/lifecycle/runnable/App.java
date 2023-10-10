package com.neol.java.finalthreads.lifecycle.runnable;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Inside thread: " + Thread.currentThread().getState());
            }

        });
        t.start();
        System.out.println("Outside thread: " + t.getState());
    }
}
