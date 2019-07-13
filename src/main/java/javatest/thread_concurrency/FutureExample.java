package javatest.thread_concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Future is an abstraction for asynchronous computation. It represents the result of the computation, which might be available at some
 * point: either a computed value or an exception. Most of the methods of the ExecutorService use Future as a return type
 * 
 * @author darekar
 */
public class FutureExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> "Future Result");
        try {
            String result = future.get(1L, TimeUnit.SECONDS);
            System.out.println("Result is '" + result + "'.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        assert future.isDone();
    }
}
