How to start kafka

1> zookeeper-server-start.sh /Users/enol/Documents/0000-Raiz/Trabajo/Programacion/Kafka/kafka_2.12-2.0.0/config/zookeeper.properties

2> kafka-server-start.sh /Users/enol/Documents/0000-Raiz/Trabajo/Programacion/Kafka/kafka_2.12-2.0.0/config/server.properties

How to see topics (—zookeeper is changed for —bootstrap-server from kafka 2.2 on)

> kafka-topics.sh --zookeeper localhost:2181  --list

How to create a topic

> kafka-topics.sh --zookeeper localhost:2181 --topic third-topic --create --partitions 3 --replication-factor 1

How to describe one or all topics

> kafka-topics.sh --zookeeper localhost:2181 --describe (all)
> kafka-topics.sh --zookeeper localhost:2181 --topic third-topic --describe

How to delete topic

> kafka-topics.sh --zookeeper localhost:2181 --topic third-topic --delete

How to start a producer (Stop with control + C)

> kafka-console-producer.sh --broker-list localhost:9092 --topic serious_topic
> kafka-console-producer.sh --broker-list localhost:9092 --topic serious_topic --producer-property acks=all
> kafka-console-producer.sh --broker-list localhost:9092 --topic serious_topic --property parse.key=true --property key.separator=,

How to start a consumer

> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic serious_topic            (shows only new produced)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic serious_topic --from-beginning            (shows all from beginning)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic serious_topic —from-beginning --group serious_group (create group)
> kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic serious_topic --group serious_group --property print.key=true --property key.separator=,

How to see consumer groups

> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
> kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group serious_group

How to reset offsets of topic

> kafka-consumer-groups.sh --bootstrap-server localhost:9092 -group serious_group --reset-offsets --to-earliest --execute --topic serious_topic