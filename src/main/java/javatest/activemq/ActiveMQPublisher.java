package javatest.activemq;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

/**
 * Publisher Subscriber Model
 *
 * Publisher publishes the message to a specified topic within JMS provider
 *  and all the subscribers who subscribed for that topic receive the message.
 *  Note that only the active subscribers receive the message.
 * @author darekar
 *
 */
public class ActiveMQPublisher {

    public void publishMessage() {

        try {
            TopicConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            TopicConnection connection = factory.createTopicConnection();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic chatTopic = new ActiveMQTopic("Test.Foo.Topic");
            TopicPublisher publisher = session.createPublisher(chatTopic);
            connection.start();
            TextMessage message = session.createTextMessage();
            Date d = new Date();
            message.setText("Hello Topic : "+d.toString());
            publisher.publish(message);
            System.out.println("Message published to topic");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
