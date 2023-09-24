package com.neol.java.threads.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        // Purpose: ReadWriteLock provides a way to differentiate between read-only and write operations. Multiple threads can read concurrently, but write operations are exclusive.
        //Features:
            //Consists of two locks: a read lock and a write lock.
            //Multiple threads can hold the read lock simultaneously, allowing for concurrent reads.
            //Only one thread can hold the write lock, ensuring exclusive write access.
        //Use Cases:
            //When you have a data structure or resource where reads are frequent, and you want to optimize concurrency.
            //It improves parallelism by allowing multiple readers to access data simultaneously while still ensuring data consistency during writes.
        ReadWriteLock lock = new ReentrantReadWriteLock();

        // Reader Thread
        new Thread(() -> {
            lock.readLock().lock(); // Acquire read lock
            try {
                System.out.println("Reader: Read lock acquired");
                // Read data
            } finally {
                lock.readLock().unlock(); // Release read lock
                System.out.println("Reader: Read lock released");
            }
        }).start();

        // Reader Thread
        new Thread(() -> {
            lock.readLock().lock(); // Acquire read lock
            try {
                System.out.println("Reader 2: Read lock acquired");
                // Read data
            } finally {
                lock.readLock().unlock(); // Release read lock
                System.out.println("Reader 2: Read lock released");
            }
        }).start();

        // Writer Thread
        new Thread(() -> {
            lock.writeLock().lock(); // Acquire write lock
            try {
                System.out.println("Writer: Write lock acquired");
                // Modify data
            } finally {
                lock.writeLock().unlock(); // Release write lock
                System.out.println("Writer: Write lock released");
            }
        }).start();
    }
}
