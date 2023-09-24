package com.neol.java.threads.lock;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    public static void main(String[] args) {
        //Purpose: StampedLock is a more advanced locking mechanism that combines elements of ReadWriteLock with additional capabilities.
        //Features:
            //Provides three modes of access: read, write, and optimistic read.
            //Multiple threads can read concurrently (similar to ReadWriteLock).
            //Only one thread can write, but StampedLock allows for an "optimistic read" mode where multiple threads can read without blocking, assuming that writes are rare.
        //Use Cases:
            //When you have a situation where reads significantly outnumber writes and you want to minimize contention.
            //It offers better performance compared to ReadWriteLock in scenarios with a high read-to-write ratio.
            StampedLock lock = new StampedLock();
        AtomicLong stamp = new AtomicLong();

        // Optimistic Read
        new Thread(() -> {
            stamp.set(lock.tryOptimisticRead());
            System.out.println("Optimistic Read: Lock acquired (Stamp: " + stamp + ")");
            // Read data
            if (!lock.validate(stamp.get())) {
                // Lock was invalidated, retry or switch to other mode
                stamp.set(lock.readLock()); // Fallback to regular read lock
            }
            System.out.println("Optimistic Read: Lock released");
            lock.unlock(stamp.get());
        }).start();

        // Write Thread
        new Thread(() -> {
            stamp.set(lock.writeLock());
            System.out.println("Write Thread: Write lock acquired (Stamp: " + stamp + ")");
            // Modify data
            System.out.println("Write Thread: Write lock released");
            lock.unlock(stamp.get());
        }).start();
    }
}
