package javatest.thread_concurrency;

/**
 * The synchronized keyword is used to prevent different threads executing the same code block simultaneously <br/>
 * type of method: static ; Reference Used as Monitor: The class object of the class with the method<br/>
 * type of method: non static ; Reference Used as Monitor: The this reference<br/>
 * 
 * @author darekar
 */
public class SynchronizedExample {

    public static void main(String[] args) {
        SynchronizedExample s = new SynchronizedExample();
        Thread t1 = new Thread(() -> s.nonStaticSynchronized());
        Thread t2 = new Thread(() -> s.nonStaticSynchronized_2());
        t1.start();
        t2.start();
    }

    private synchronized static void staticSynchronized() {

    }

    public synchronized void nonStaticSynchronized() {
        System.out.println("nonStaticSynchronized");
    }
    public synchronized void nonStaticSynchronized_2() {
        System.out.println("nonStaticSynchronized_2");
    }
}

class AtomicOperation {

    private int counter0;
    private int counter1;

    void increment() {
        synchronized (this) {
            counter0++;
            counter1++;
        }
        System.out.println(Thread.currentThread() + " counter0:" + counter0 + " counter1:" + counter1);
    }
}