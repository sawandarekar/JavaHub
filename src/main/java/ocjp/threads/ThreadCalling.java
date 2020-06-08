package ocjp.threads;

public class ThreadCalling {

    public static void main(final String[] args) {
        System.out.println("ThreadCalling main: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        final TestThread obj = new TestThread();
        obj.start();
        obj.func1();
        // obj.start();//"main" java.lang.IllegalThreadStateException
        final TestRunnable runnable = new TestRunnable();
        final Thread runnableThread = new Thread(runnable);
        runnableThread.start();
    }

}

class TestThread extends Thread {

    public TestThread() {
        
        System.out
            .println("TestThread cunstructor: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Test Thread run: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
    }

    public void func1() {
        System.out.println("Test Thread func1: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        // start(); //"main" java.lang.IllegalThreadStateException

    }
}

class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("TestRunnable run: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
    }
}