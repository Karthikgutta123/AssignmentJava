//Q8. Implement the Producer-Consumer problem using BlockingQueue.

package main;

import java.util.concurrent.*;

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println("Produced: " + i);
                queue.put(i); // put() blocks if the queue is full
                Thread.sleep(100); // simulate production time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer item = queue.take(); // take() blocks if the queue is empty
                System.out.println("Consumed: " + item);
                Thread.sleep(150); // simulate consumption time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class blockQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}