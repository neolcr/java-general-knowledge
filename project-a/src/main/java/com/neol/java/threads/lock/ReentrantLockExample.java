package com.neol.java.threads.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        // Purpose: ReentrantLock is a mutual exclusion lock, meaning it allows only one thread to access a critical section of code at a time.
        // Features:
            //It is "reentrant," which means that a thread that already holds the lock can acquire it again without blocking itself.
            //Supports fairness policies, where the longest-waiting thread gets access to the lock.
            //Provides methods like lock() and unlock() for explicit locking and unlocking.
        // Use Cases:
            //When you need fine-grained control over locking and unlocking, such as implementing custom synchronization constructs.
            //It can be used as a drop-in replacement for synchronized blocks.
        ReentrantLock lock = new ReentrantLock();

        // Thread 1
        new Thread(() -> {
            lock.lock(); // Acquire the lock
            try {
                System.out.println("Thread 1: Lock acquired");
                // Critical section
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // Release the lock
                System.out.println("Thread 1: Lock released");
            }
        }).start();

        // Thread 2
        new Thread(() -> {
            lock.lock(); // Acquire the lock
            try {
                System.out.println("Thread 2: Lock acquired");
                // Critical section
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // Release the lock
                System.out.println("Thread 2: Lock released");
            }
        }).start();

        // Thread 3
        new Thread(() -> {
            lock.lock(); // Acquire the lock
            try {
                System.out.println("Thread 3: Lock acquired");
                // Critical section
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // Release the lock
                System.out.println("Thread 3: Lock released");
            }
        }).start();
    }
}
