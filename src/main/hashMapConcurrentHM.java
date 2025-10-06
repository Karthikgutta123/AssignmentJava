// Write a program to demonstrate the difference between HashMap and ConcurrentHashMap in a multithreaded environment.


package main;

import java.util.*;
import java.util.concurrent.*;

public class hashMapConcurrentHM {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, String> hashMap = new HashMap<>();

        Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        System.out.println("=== hashMap Test (Not Thread-Safe) ===");
        runTest(hashMap);

        System.out.println("\n=== ConCurrentHashMap Test (Thread-Safe) ===");
        runTest(concurrentMap);
    }

    private static void runTest(Map<Integer, String> map) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");
        Thread t4 = new Thread(task, "T4");
        Thread t5 = new Thread(task, "T5");

        t1.start(); t2.start(); t3.start(); t4.start(); t5.start();

        t1.join(); t2.join(); t3.join(); t4.join(); t5.join();

        System.out.println("Final size: " + map.size());
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " => " + map.get(i));
        }
    }
}
