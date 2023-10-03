package com.neol.java.threads.geekfic.lock.stamped;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        optimisticRead();
    }

    private static void optimisticRead() throws InterruptedException {
        StampedLock lock = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
           long stamp = lock.tryOptimisticRead();
           try{
               System.out.println("Optimistic Lock valid: " + lock.validate(stamp));
               Thread.sleep(2_000);
               System.out.println("Optimistic Lock valid: " + lock.validate(stamp));
               Thread.sleep(2_000);
               System.out.println("Optimistic Lock valid: " + lock.validate(stamp));
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               lock.unlock(stamp);
           }
        });

        executor.submit(()->{
           long stamp = lock.writeLock();
           try{
               System.out.println("Write lock acquired");
               Thread.sleep(2_000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               System.out.println("Write done");
               lock.unlock(stamp);
           }
        });

        if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
            executor.shutdownNow();
            System.out.println("END");
        }
    }

    private static void stamplockExample1() throws InterruptedException {
        List<String> list = new ArrayList<>();
        StampedLock lock = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable writeTask = () -> {
            long stamp = lock.writeLock();
            try{
                list.add("stored: "  + stamp);
                // TODO: check why changing this to 5 seconds is crashing
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        };

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try{
                System.out.println(list.get(0) + " my stamp: " + stamp);
                // TODO: check why changing this to 5 seconds is crashing
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
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
