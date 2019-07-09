package ocjp.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueSetup {

    public static void main(String[] args) {
        BlockingQueue<Worker> q = new ArrayBlockingQueue<>(100);
        Producer p = new Producer(q);
        Consumer c1 = new Consumer("consOne",q);
        Consumer c2 = new Consumer("consTwo",q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer implements Runnable{
    BlockingQueue<Worker> blockingQueue;
    public Producer(BlockingQueue<Worker> q) {
        blockingQueue = q;
    }
    @Override
    public void run() {
        try {
            System.out.println("Producing");
            int i = 0;
            while(i++<10) {
                blockingQueue.put(new Worker());
            }
        }catch (InterruptedException e) {
        }
    }

}

class Consumer implements Runnable{
    String consumerName;
    BlockingQueue<Worker> blockingQueue;
    public Consumer(String name,BlockingQueue<Worker> q) {
        consumerName = name;
        blockingQueue = q;
    }
    @Override
    public void run() {
        try {
            System.out.println("Consuming on :"+consumerName);
            while (true) {
                Worker w = blockingQueue.take();
                w.startedFrom = consumerName;
                Thread t= new Thread(w);
                t.start();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}

class Worker implements Runnable{
    String startedFrom;
    @Override
    public void run() {
        System.out.println("Working "+Thread.currentThread().getName() + " started from:"+startedFrom);
    }
}