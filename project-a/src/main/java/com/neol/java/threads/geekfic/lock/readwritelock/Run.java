package com.neol.java.threads.geekfic.lock.readwritelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Run {
    public static void main(String ... args) throws InterruptedException {
        readwritelockExample1();
    }

    private static void readwritelockExample1() throws InterruptedException {
        List<String> list = new ArrayList<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable writeTask = () -> {
            lock.writeLock().lock();
            try{
                list.add("example");
                // TODO: check why changing this to 5 seconds is crashing
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        };

        Runnable readTask = () -> {
            lock.readLock().lock();
            try{
                System.out.println(list.get(0));
                // TODO: check why changing this to 5 seconds is crashing
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        };

        executor.submit(writeTask);
        //All reads will be executed simultaneously (read aquired lock at the same time)
        executor.submit(readTask);
        executor.submit(readTask);
        executor.submit(readTask);

        if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
            executor.shutdownNow();
            System.out.println("End");
        }
    }
}
