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

    }

    private synchronized static void staticSynchronized() {

    }

    public synchronized void nonStaticSynchronized() {

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