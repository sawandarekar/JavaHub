package javatest.activemq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Point to point messaging model
 *
 * Producer sends the message to a specified queue within JMS provider and
 * the only one of the consumers who listening to that queue receives that message.
 *
 * @author darekar
 *
 */
public class ActiveMQProducer implements Runnable{

    @Override
    public void run() {
        System.out.println("Executing Producer ThreadID:"+Thread.currentThread().getId());

        try {
            //Create Connection Factory
            //ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            //Create Connection
            Connection connection = factory.createConnection();
            connection.start();
            //Create Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //Create Destination(Topic or queue)
            Destination destination =  session.createQueue("Test.FOO");
            //Create message producer from session to topic or queue
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //Create Message
            String message = "Hello ActiveMQ from :"+ Thread.currentThread().getName() + " : " + this.hashCode();
            TextMessage textMessage = session.createTextMessage(message);
            //Tell producer to send message
            messageProducer.send(textMessage);
            System.out.println("Send Message to Queue");
            //Clean up
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
