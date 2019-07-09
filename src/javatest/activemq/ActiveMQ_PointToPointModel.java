package javatest.activemq;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ActiveMQ_PointToPointModel {

    public static void main(String[] args) {
        Date d = new Date();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable pr = new ActiveMQProducer();
        Runnable con = new ActiveMQConsumer();
        for (int i = 0; i < 5; i++) {
            executorService.execute(pr);
            executorService.execute(con);
        }
        executorService.shutdown();
        System.out.println("shutdown : "+d.toString());
    }
}
