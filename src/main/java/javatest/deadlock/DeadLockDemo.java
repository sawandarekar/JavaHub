package javatest.deadlock;

/**
 * program will create deadlock.s
 * 
 * @author darekar
 *
 */
public class DeadLockDemo {

    public void method1() {
	synchronized (String.class) {
	    System.out.println("method1: Acquired lock on string class object");
	    synchronized (Integer.class) {
		System.out.println("method1: Acquired lock on Integer class object");
	    }
	}
    }

    public void method2() {
	synchronized (Integer.class) {
	    System.out.println("method2: Acquired lock on Integer class object");
	    synchronized (String.class) {
		System.out.println("method2: Acquired lock on string class object");
	    }
	}
    }

    /**
     * If method1() and method2() both will be called by two or many threads , there
     * is a good chance of deadlock because if thread 1 acquires lock on Sting
     * object while executing method1() and thread 2 acquires lock on Integer object
     * while executing method2() both will be waiting for each other to release lock
     * on Integer and String to proceed further which will never happen.
     * 
     * Read more:
     * https://javarevisited.blogspot.com/2018/08/how-to-avoid-deadlock-in-java-threads.html#ixzz5NwjHb5gL
     * 
     * @param args
     */
    public static void main(String[] args) {
	DeadLockDemo deadLockDemo = new DeadLockDemo();
	Runnable r1 = () -> {
	    deadLockDemo.method1();
	};
	Runnable r2 = () -> {
	    deadLockDemo.method2();
	};

	Thread t1 = new Thread(r1);
	t1.start();
	Thread t2 = new Thread(r2);
	t2.start();
    }
}
