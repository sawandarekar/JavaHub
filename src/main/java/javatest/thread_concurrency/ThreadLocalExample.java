package javatest.thread_concurrency;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * One way to contain data within a thread and make locking unnecessary is to use ThreadLocal storage. Conceptually, ThreadLocal acts as if
 * there is a variable with its own version in every Thread. ThreadLocals are commonly used for stashing per-Thread values like the "current
 * transaction" or other resources. Also, they are used to maintain per-thread counters, statistics, or ID generators.
 *
 * @author darekar
 */
public class ThreadLocalExample {

    public static void main(String[] args) throws InterruptedException {
        Runnable obj = new ThreadLocalTest();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            //Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

}

class ThreadLocalTest implements Runnable {

    // Atomic integer containing the next thread ID to be assigned
    AtomicInteger nextId = new AtomicInteger(0);
    ThreadLocal<String> threadLocalString = ThreadLocal.withInitial(()-> "first");

    ThreadLocal<AtomicInteger> threadLocal_java8 = ThreadLocal.withInitial(()->nextId);

    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };


    @Override
    public void run() {
        System.out.println("threadLocal_java8:" + threadLocal_java8.get().getAndIncrement() + ":Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern() + " threadLocalString:" + threadLocalString.get());
//        try {
//            Thread.sleep(new Random().nextInt(1000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        //System.out.println(thradLocal_java8.get()+":Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern()+" threadLocalString:"+threadLocalString.get());
    }
}