package javatest.thread_concurrency;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorFrameworksRejectedExecutionHandler {

    public static void main(String[] args) {
        ExecutorFrameworksRejectedExecutionHandler handler = new ExecutorFrameworksRejectedExecutionHandler();
        handler.checkAbortPolicy();
        handler.checkCallerRunsPolicy();
    }

    private void checkCallerRunsPolicy() {
        log.info("-----checkCallerRunsPolicy-------");

//        ExecutorService executor = new ThreadPoolExecutor(1, 1,
//            0L, TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<Runnable>(1));
           ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, MILLISECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(() -> waitFor(1,250));
        executor.execute(() -> waitFor(2,250));
        executor.execute(() -> waitFor(3,250));
        executor.execute(() -> waitFor(4,250));
        executor.execute(() -> waitFor(5,250));
        executor.execute(() -> waitFor(6,250));

        long startTime = System.currentTimeMillis();
        executor.execute(() -> waitFor(7, 500));
        long blockedDuration = System.currentTimeMillis() - startTime;

        log.info("{} : checkCallerRunsPolicy 3 blockedDuration:{}", Thread.currentThread().getName(),blockedDuration);
        executor.shutdown();
    }

    private void waitFor(int i, int millis) {
        try {
            log.info("{} : {}-start waiting:{} millis", Thread.currentThread().getName(),i, millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkAbortPolicy() {
        log.info("-----checkAbortPolicy-------");

        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, MILLISECONDS,
            new SynchronousQueue<>(),
            new ThreadPoolExecutor.AbortPolicy());

        executor.execute(() -> waitFor(1, 250));

        try {
            executor.execute(() -> log.error("{} :Will be rejected", Thread.currentThread().getName()));
        }catch (RejectedExecutionException e){
            log.error("Exception:",e);
        }
        executor.shutdown();
    }
}
