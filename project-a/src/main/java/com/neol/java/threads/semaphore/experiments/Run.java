package com.neol.java.threads.semaphore.experiments;

import java.util.concurrent.Semaphore;

public class Run {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        System.out.println("Semaphore available permits: " + semaphore.availablePermits());
        semaphore.release();
        System.out.println("Semaphore available permits: " + semaphore.availablePermits());
        semaphore.release();
        System.out.println("Semaphore available permits: " + semaphore.availablePermits());
    }
}
