package javatest.thread_concurrency;

/**
 * A race condition occurs when more than one thread is performing a series of actions on shared resources, and several possible outcomes
 * can exist based on the order of the actions from each thread.
 * 
 * @author darekar
 */
public class RaceConditionExample {

    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper = new LongWrapper(0L);
        Runnable r = () ->{
            for (int i = 0; i < 1_000; i++) {
                longWrapper.increment();
            }
        };

//        Thread t1 = new Thread(r);
//        t1.start();
//
//        t1.join();
//
        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("value:"+longWrapper.getVal());
    }

//    private volatile T value;
//
//    T get() {
//        if (value == null) {
//            value = initialize();
//        }
//        return value;
//    }
//
//    private T initialize() {
//        return null;
//    }
}
class LongWrapper{
    //how to solve race condition add synchronized block
    Object key = new Object();
    private long l;
    public LongWrapper(long l){
        this.l = l;
    }
    public long getVal(){
        return this.l;
    }
    public void increment(){
        synchronized (key) {
            this.l = this.l + 1;
        }
    }
}
