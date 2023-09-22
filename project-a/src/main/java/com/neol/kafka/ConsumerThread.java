package com.neol.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

class ConsumerThread implements Runnable {

    private Consumer<String, String> consumer;
    private final String topic;
    private final String groupId;

    ConsumerThread(String topic, String groupId) {
        this.topic = topic;
        this.groupId = groupId;
        consumer = new KafkaConsumer<>(getProperties());
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    @Override
    public void run() {
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            ConsumerRecords<String, String> record = consumer.poll(100);
            record.forEach(r -> {
                System.out.println(Thread.currentThread().getName()
                        + " Key: " + r.key()
                        + " Value: " + r.value()
                        + " Topic: " + r.topic()
                        + " Partition: " + r.partition()
                        + " Offset: " + r.offset()
                );
            });
        }

    }
}
