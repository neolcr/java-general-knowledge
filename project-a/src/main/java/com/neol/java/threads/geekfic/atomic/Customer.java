package com.neol.java.threads.geekfic.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static AtomicInteger idCounter = new AtomicInteger(0);
    private int id;

    public Customer(){
        id = idCounter.getAndIncrement();
    }


    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
