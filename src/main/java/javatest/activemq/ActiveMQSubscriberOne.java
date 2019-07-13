package javatest.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class ActiveMQSubscriberOne implements MessageListener{
    public void Subscribe() {
        try {
            TopicConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            TopicConnection connection = factory.createTopicConnection();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic chatTopic = new ActiveMQTopic("Test.Foo.Topic");
            TopicSubscriber subscriber = session.createSubscriber(chatTopic);
            subscriber.setMessageListener(this);
            connection.start();
            System.out.println("One subscribed to topic");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println("Subscriber One Listener:"+text);
        } catch (JMSException jmse) {
            jmse.printStackTrace();
        }
    }

}
