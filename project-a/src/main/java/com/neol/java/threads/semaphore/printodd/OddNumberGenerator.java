package com.neol.java.threads.semaphore.printodd;

public class OddNumberGenerator implements Runnable{

    private OddAndEvenNumberGenerator oddAndEvenNumberGenerator;
    private int totalNumberInSequence;

    public OddNumberGenerator(OddAndEvenNumberGenerator oddAndEvenNumberGenerator, int totalNumberInSequence) {
        this.oddAndEvenNumberGenerator = oddAndEvenNumberGenerator;
        this.totalNumberInSequence = totalNumberInSequence;
    }

    @Override
    public void run() {
        for(int i = 1; i<= totalNumberInSequence; i = i + 2){
            oddAndEvenNumberGenerator.printOddNumber(i);
        }
    }
}
