package javatest.thread_concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadLocalExecutorFramework {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0,10).forEach((i)-> executorService.submit(new ThreadLocalExecutorThread()));
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
    }
}
class ThreadLocalExecutorThread implements Runnable{
    int v = 0;
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->0);

    @Override
    public void run() {
        Integer i = threadLocal.get();
        System.out.println("Name:"+Thread.currentThread().getName()+" threadLocal:"+i+" val:"+v++);
        i += 1;
        threadLocal.set(i);
    }
}