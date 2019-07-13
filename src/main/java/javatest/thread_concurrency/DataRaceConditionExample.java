package javatest.thread_concurrency;

/**
 * <b>DATA RACE </b><br/>
 * A data race occurs when 2 or more threads try to access the same non-final variable without synchronization. Not using synchronization
 * may lead to making changes which are not visible to other threads, so reading the stale data is possible, which in turn may have
 * consequences such as infinite loops, corrupted data structures, or inaccurate computations.<br/>
 * This code might result in an infinite loop, because the reader thread may never observe the changes made by the writer threads
 * 
 * @author darekar
 */
class Waiter implements Runnable {

    private boolean shouldFinish;

    void finish() {
        shouldFinish = true;
    }

    @Override
    public void run() {
        long iteration = 0;
        while (!shouldFinish) {
            System.out.println("interation:" + iteration);
            iteration++;
        }
        System.out.println("Finished after: " + iteration);
    }
}

class DataRaceConditionExample {

    public static void main(String[] args)
        throws InterruptedException {
        System.out.println("Number of cores:" + Runtime.getRuntime().availableProcessors());
        Waiter waiter = new Waiter();
        Thread waiterThread = new Thread(waiter);
        waiterThread.start();
        // Thread.sleep(1000l);
        waiter.finish();
        waiterThread.join();
    }
}
