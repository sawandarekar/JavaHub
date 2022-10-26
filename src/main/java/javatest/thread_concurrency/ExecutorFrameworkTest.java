package javatest.thread_concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorFrameworkTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100000; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    Thread.sleep(50); //to simulate slow I/O
                    log.info("{}:After Runnable is executed", finalI);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            });
            log.info("Task Submitted");
        }
        executorService.shutdown();
        log.info("shutdown initiated");
    }

    public static void main1(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 1000000).forEach(i ->{
            log.info("submitting i:{}", i);
            executorService.submit(() ->{
                log.info("processing i:{}", i);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        executorService.shutdown();
    }
}
