//    Implement a multithreaded program where two threads print odd and even numbers alternately up to 20.


package main;

class printNum {
    private final int MAX = 20;

    public void printOdd() {
        StringBuilder sb = new StringBuilder("Odd Thread: ");
        for (int i = 1; i <= MAX; i += 2) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public void printEven() {
        StringBuilder sb = new StringBuilder("Even Thread: ");
        for (int i = 2; i <= MAX; i += 2) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

public class oddEvenMultiththread {
    public static void main(String[] args) {
        printNum printer = new printNum();

        Thread oddThread = new Thread(printer::printOdd);//Lambda can be replaced with method reference
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }
}


