package com.neol;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.stream.IntStream;

public class ActiveMQMessageProducer {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("MyQueueA");
        Topic topic = session.createTopic("topic-a");
        MessageProducer producer = session.createProducer(topic);
        IntStream.range(0, 100).forEach(i -> {
            TextMessage message = null;
            try {
                message = session.createTextMessage("Hello, ActiveMQ");
                producer.send(message);
                System.out.println("Message sent: " +  message.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        });

        connection.close();

    }
}
