package com.neol.java.finalthreads.waitnotify;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Object lockMonitor = new Object();

        Thread t1 = new Thread(() -> {
            while(true){
                synchronized (lockMonitor){
                    System.out.println("Thread 1: enter key");
                    new Scanner(System.in).nextLine();
                    System.out.println("Thread 1: Got key!");
                    try {
                        System.out.println("Thread 1 goes to wait");
                        lockMonitor.wait();
                        System.out.println("Thread 1 wakes up");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lockMonitor.notify();
                }

            }
        });

        Thread t2 = new Thread(() -> {
            while(true){
                synchronized (lockMonitor){
                    System.out.println("Thread 2: enter key");
                    new Scanner(System.in).nextLine();
                    System.out.println("Thread 2: Got key!");
                    lockMonitor.notify();
                    try {
                        System.out.println("Thread 2 goes to wait");
                        lockMonitor.wait();
                        System.out.println("Thread 2 wakes up");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("End");



    }
}
