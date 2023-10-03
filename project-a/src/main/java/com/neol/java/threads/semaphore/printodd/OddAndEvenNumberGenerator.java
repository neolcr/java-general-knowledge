package com.neol.java.threads.semaphore.printodd;

import java.util.concurrent.Semaphore;

public class OddAndEvenNumberGenerator {
    private Semaphore semaphoreOdd = new Semaphore(1);
    private Semaphore semaphoreEven = new Semaphore(0);

    public void printOddNumber(int number){
        try {
            semaphoreOdd.acquire();
            System.out.println(Thread.currentThread().getName()+" acquired -> :"+number);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreEven.release();
        }
    }

    public void printEvenNumber(int number){
        try {
            semaphoreEven.acquire();
            System.out.println(Thread.currentThread().getName()+" acquired -> :"+number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreOdd.release();
        }
    }
}
