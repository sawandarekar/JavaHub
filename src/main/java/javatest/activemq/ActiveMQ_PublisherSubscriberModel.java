package javatest.activemq;


public class ActiveMQ_PublisherSubscriberModel {

    public static void main(String[] args) {
        //        ActiveMQSubscriberOne one = new ActiveMQSubscriberOne();
        //        one.Subscribe();
        //        ActiveMQSubscriberTwo two = new ActiveMQSubscriberTwo();
        //        two.Subscribe();
        ActiveMQPublisher activeMQPublisher = new ActiveMQPublisher();
        //for (int i = 0; i < 3; i++) {
        activeMQPublisher.publishMessage();
        //}
    }

}
