package javatest.thread_concurrency;

import java.util.concurrent.TimeUnit;

public class InterruptedExceptionTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("isInterrupted:"+Thread.currentThread().isInterrupted());
        Thread t = new Thread(new ComplicatedCalculator());
        t.start();
        Thread.sleep(50L);
        t.interrupt();
        Thread t1 = new Thread(new Simulation());
        //t1.start();
        Thread cleanerThread = new Thread(new Cleaner(), "Cleaner");
        cleanerThread.start();
    }
}
class Cleaner implements Runnable, AutoCloseable {

    //private final Thread cleanerThread;

    Cleaner() {
        //cleanerThread = new Thread(this, "Cleaner");
        //cleanerThread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                cleanUp();
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException ignored) {
            System.out.println("Interrupted, closing");
        }
    }

    private void cleanUp() {
        System.out.println("cleanUp");
    }

    @Override
    public void close() {
        System.out.println("close, closing");
    }
}

class ComplicatedCalculator implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("ComplicatedCalculator: not interrupted");
        }
        System.out.println("ComplicatedCalculator run completed");
    }
}

class Simulation implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Simulation: not interrupted");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Simulation: completed");
    }
}