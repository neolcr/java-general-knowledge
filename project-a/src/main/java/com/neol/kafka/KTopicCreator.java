package com.neol.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.Properties;

public class KTopicCreator {

    private static Properties getProperties(){
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return properties;
    }

    public static void createTopic(String topic, int partitions, int replicationFactor){
        try(AdminClient adminClient = AdminClient.create(getProperties())){
            NewTopic newTopic = new NewTopic(topic, partitions, (short) replicationFactor);
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            System.out.println("Created topic: " + newTopic.name());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
