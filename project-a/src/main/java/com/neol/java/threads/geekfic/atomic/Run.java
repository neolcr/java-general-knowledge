package com.neol.java.threads.geekfic.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Run {
    public static void main(String[]args){
        List<Customer> customerList = new ArrayList<>();

        for (int i = 0; i <= 20; i++){
            Thread t1 = new Thread(() -> {
                customerList.add(new Customer());
            });
            t1.start();

        }

        System.out.println(customerList);

    }
}
