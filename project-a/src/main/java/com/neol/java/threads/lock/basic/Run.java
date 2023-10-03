package com.neol.java.threads.lock.basic;

public class Run {
    public static void main(String...args) throws InterruptedException {
        new Worker().main();
    }
}
