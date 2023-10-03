package com.neol.java.threads.waitnotify;

import java.util.Scanner;

public class Processor {
    private final Object lock = new Object();

    public void produce() throws InterruptedException{
        synchronized (lock){
            System.out.println("Producer thread running....");
            lock.wait(); // relinquish the lock inmmediatly (next line wont be executed)
            Thread.sleep(5000);
            System.out.println("Resumed.");
        }

    }

    public void consume() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (lock){
            System.out.println("Waiting for return key..");
            scanner.nextLine();
            System.out.println("Return key pressed");
            lock.notify(); // relinquish the lock only when the code execution is complete
            Thread.sleep(5000);
        }
    }

}
