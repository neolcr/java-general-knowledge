package com.neol;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ActiveMQMessageConsumer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {
            Connection connection;
            try {
                connection = connectionFactory.createConnection();
//                connection.setClientID("Consumer" + i);
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("MyQueueA");
                Topic topic = session.createTopic("topic-B");
                MessageConsumer consumer = session.createConsumer(topic);
                Message message = consumer.receive();
                assert(message instanceof TextMessage);
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Received message: " + textMessage.getText());

            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        });

    }
}

class ThreadConsumer implements Runnable{
    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

    @Override
    public void run() {
        Connection connection;
        try {
            System.out.println("Leega");
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("MyQueueA");
            Topic topic = session.createTopic("topic-a");
            MessageConsumer consumer = session.createConsumer(topic);
            Message message = consumer.receive();
            assert(message instanceof TextMessage);
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received message: " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
