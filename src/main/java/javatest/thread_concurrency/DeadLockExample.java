package javatest.thread_concurrency;

public class DeadLockExample {

    public static void main(String[] args) throws InterruptedException {
        DealLock d = new DealLock();
        Thread t1 = new Thread(() -> d.a());
        t1.start();
        Thread t2 = new Thread(() -> d.b());
        t2.start();

        t1.join();
        t2.join();
    }
}

class DealLock{
    private Object key1 = new Object();
    private Object key2 = new Object();

    public void a(){
        synchronized (key1){
            System.out.println("["+Thread.currentThread().getName()+"] i am in a()");
            b();
        }
    }
    public void b(){
        synchronized (key2){
            System.out.println("["+Thread.currentThread().getName()+"] i am in b()");
            c();
        }
    }
    public void c(){
        synchronized (key1){
            System.out.println("["+Thread.currentThread().getName()+"] i am in c()");
        }
    }
}
