package com.neol.java.threads.semaphore.printodd;

public class EvenNumberGenerator implements Runnable{

    private OddAndEvenNumberGenerator oddAndEvenNumberGenerator;
    private int totalNumberInSequence;

    public EvenNumberGenerator(OddAndEvenNumberGenerator oddAndEvenNumberGenerator, int totalNumberInSequence) {
        this.oddAndEvenNumberGenerator = oddAndEvenNumberGenerator;
        this.totalNumberInSequence = totalNumberInSequence;
    }

    @Override
    public void run() {
        for(int i = 2; i<= totalNumberInSequence; i = i + 2){
            oddAndEvenNumberGenerator.printEvenNumber(i);
        }
    }
}
