// Create a program to implement a thread-safe Singleton class using double-checked locking.

package main;

class singleTon {
    private static volatile singleTon instance;

    private singleTon() {
        System.out.println("singleTon instance created.");
    }

    public static singleTon getInstance() {
        if (instance == null) {
            synchronized (singleTon.class) {
                if (instance == null) {
                    instance = new singleTon();
                }
            }
        }
        return instance;
    }

    public static void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

public class safeSingleton {
    public static void main(String[] args) {
        Runnable task = () -> {
            singleTon singleton = singleTon.getInstance();
            singleTon.showMessage();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}