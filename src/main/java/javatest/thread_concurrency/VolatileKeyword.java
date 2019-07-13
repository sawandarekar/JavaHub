package javatest.thread_concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * volatile solves the problem of visibility, and makes changes of the variable’s value to be atomic, because there is a happens-before
 * relationship: write to a volatile variable happens before any subsequent read from the volatile variable. Therefore, it guarantees that
 * any subsequent reads of the field will see the value, which was set by the most recent write.
 * 
 * @author darekar
 */
public class VolatileKeyword implements Runnable {

    private volatile boolean shouldStop;
    AtomicBoolean ato = new AtomicBoolean();

    @Override
    public void run() {
        while (!shouldStop) {
            System.out.println(Thread.currentThread().getName() + ": should Stop:" + shouldStop);
        }
        System.out.println("Stopped.");
    }

    void stop() {
        shouldStop = true;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileKeyword flag = new VolatileKeyword();
        Thread thread = new Thread(flag);
        thread.start();
        flag.stop();
        thread.join();
    }
}