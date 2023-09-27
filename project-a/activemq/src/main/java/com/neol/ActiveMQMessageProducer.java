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
        Topic topic = session.createTopic("topic-B");
        MessageProducer producer = session.createProducer(topic);

        TextMessage message;
        try {
            message = session.createTextMessage("message B" );
            producer.send(message);
            System.out.println("Message sent: " +  message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }



        //connection.close();

    }
}
