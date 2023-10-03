package com.neol.java.threads.semaphore.printodd;

public class OddEvenNumberPrintByTwoThreadsTest {
    public static void main(String[] args) {
        int total = 20;
        OddAndEvenNumberGenerator oddAndEvenNumberGenerator = new OddAndEvenNumberGenerator();
        OddNumberGenerator oddNumberGenerator = new OddNumberGenerator(oddAndEvenNumberGenerator, total);
        EvenNumberGenerator evenNumberGenerator = new EvenNumberGenerator(oddAndEvenNumberGenerator, total);

        Thread t1 = new Thread(oddNumberGenerator, "Thread-Odd");
        Thread t2 = new Thread(evenNumberGenerator, "Thread-Even");

        t1.start();
        t2.start();
    }
}
