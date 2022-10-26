package javatest.thread_concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadLocalExecutorFramework {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        IntStream.range(0, 10).forEach(i -> executorService.submit(new ThreadLocalExecutorThread()));
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
    }
}

class ThreadLocalExecutorThread implements Runnable {

    int v = 0;
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    @Override
    public void run() {
        Integer i = threadLocal.get();
        Integer j = 2;
        threadLocal.set(j);
        System.out.println("Name:" + Thread.currentThread().getName() + " threadLocal:" + i + " val:" + v+++" j:"+j);
    }
}