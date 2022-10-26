package javatest.thread_concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorShutdownTest {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        log.info("WorkerTasks scheduled at : " + LocalDateTime.now());

        ScheduledFuture<String> result1 = executor.schedule(new WorkerTask(
            "WorkerTask-1"), 5, TimeUnit.SECONDS);

        ScheduledFuture<String> result2 = executor.schedule(new WorkerTask(
            "WorkerTask-2"), 10, TimeUnit.SECONDS);

        ScheduledFuture<String> result3 = executor.schedule(new WorkerTask(
            "WorkerTask-3"), 20, TimeUnit.SECONDS);

        ScheduledFuture<String> result4 = executor.schedule(new WorkerTask(
            "WorkerTask-4"), 40, TimeUnit.SECONDS);

        Thread.sleep(15_000);
        log.info("***********Shutting down the executor service*********");
        executor.shutdown();

        log.info("***********Tasks are partially completed*********");

        log.info("Task-1 is done : " + result1.isDone());
        log.info("Task-2 is done : " + result2.isDone());
        log.info("Task-3 is done : " + result3.isDone());
        log.info("Task-4 is done : " + result4.isDone());

        log.info("***********Waiting for tasks to be complete*********"+ LocalDateTime.now());
        executor.awaitTermination(5, TimeUnit.SECONDS);

        log.info("***********All tasks are completed now*********"+ LocalDateTime.now());

        log.info("Task-1 is done : " + result1.isDone());
        log.info("Task-2 is done : " + result2.isDone());
        log.info("Task-3 is done : " + result3.isDone());
        log.info("Task-4 is done : " + result4.isDone());
    }
}

@Slf4j
class WorkerTask implements Callable<String> {

    private final String name;

    public WorkerTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        log.info("WorkerTask [" + name + "] executed on : "
                           + LocalDateTime.now().toString());
        return "WorkerTask [" + name + "] is SUCCESS !!";
    }
}