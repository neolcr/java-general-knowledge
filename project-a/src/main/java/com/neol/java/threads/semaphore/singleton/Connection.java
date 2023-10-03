package com.neol.java.threads.semaphore.singleton;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance;
    private int connections = 0;
    private Semaphore semaphore = new Semaphore(10);

    private Connection(){}

    public static Connection getInstance(){
        if (instance == null){
            instance = new Connection();
        }
        return instance;
    }

    public void connect() throws InterruptedException {
        semaphore.acquire();
        synchronized (this){
            connections++;
            System.out.println("Thread: " + Thread.currentThread().getName() + " Current connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            connections--;
        }

        semaphore.release();

    }


}
