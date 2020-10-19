package ocjp.threads;

public class YieldDemo {

    public static void main(String[] args) {
        Thread t = new Thread(new MyLocalThread());
        t.start();

        for (int i = 0; i < 5_00; i++) {
            // Control passes to child thread
            Thread.yield();

            // After execution of child Thread
            // main thread takes over
            System.out.println(Thread.currentThread().getName() + " in control:"+i);
        }
    }
}

class MyLocalThread extends Thread {

    public void run() {
        for (int i = 0; i < 5_00; i++) {
            // Control passes to child thread
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " in control:"+i);
        }
    }
}
