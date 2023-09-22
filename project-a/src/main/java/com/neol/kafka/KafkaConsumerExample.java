package com.neol.kafka;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class KafkaConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        String topica = "topic-a";
        String topicb = "topic-b";
        String topicc = "topic-c";
        String groupIdA = "group-a";
        String groupIdB = "group-b";
        String groupIdC = "group-c";
        List<String> topics = Arrays.asList(topica, topicb, topicc);

        KTopicCreator.createTopic(topica, 3, 1);

        Thread c1 = new Thread(new ConsumerThread(topica, groupIdA));
        Thread c2 = new Thread(new ConsumerThread(topica, groupIdA));
        Thread c3 = new Thread(new ConsumerThread(topica, groupIdA));

        c1.start();
        c2.start();
        c3.start();

        KProducer imProducer = new KProducer();
        Random random = new Random();

        IntStream.range(0, 100).forEach(i -> {

            imProducer.send(topics.get(random.nextInt(3)), String.valueOf(i), "message"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

}


