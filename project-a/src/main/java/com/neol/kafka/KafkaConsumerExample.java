package com.neol.kafka;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class KafkaConsumerExample {
    public static void main(String[] args) throws InterruptedException, IOException {
        String topica = "topic-a";
        String topicb = "topic-b";
        String topicc = "topic-c";
        String groupIdA = "group-a";
        String groupIdB = "group-b";
        String groupIdC = "group-c";
        ProcessBuilder processBuilder = new ProcessBuilder(List.of("bash", "-c","/Users/enol/Documents/kafka_2.13-3.5.1/bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic " +  topica +" --delete"));
        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        System.out.println("Command executed with exit code: "+ exitCode);
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

//            imProducer.send(topics.get(random.nextInt(3)), String.valueOf(i), "message"+i);
            imProducer.send(topica, String.valueOf(i), "message"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

}


