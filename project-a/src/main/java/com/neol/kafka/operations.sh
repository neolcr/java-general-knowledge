#!/bin/bash

# 0 Describe all topics
# 1 Delete topic
# 10 List all consumer group
# 11 Describe consumer group
# 12 Reset group offset


option="1"
topic="topic-a"
consumergroup="group-a"

if [ "$option" == "0" ]
then
  echo Describe topics
  /Users/enol/Documents/kafka_2.13-3.5.1/bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe
fi

if [ "$option" == "1" ]
then
  echo Delete topic
  /Users/enol/Documents/kafka_2.13-3.5.1/bin/kafka-topics.sh --bootstrap-server localhost:9092 --topic $topic --delete
fi

if [ "$option" == "10" ]
then
  echo List all groups
  /Users/enol/Documents/kafka_2.13-3.5.1/bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
fi

if [ "$option" == "11" ]
then
  echo Describe consumer group
  /Users/enol/Documents/kafka_2.13-3.5.1/bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group $consumergroup
fi

if [ "$option" == "12" ]
then
  echo Reset offset in consumer group
  /Users/enol/Documents/kafka_2.13-3.5.1/bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 \
  --group $consumergroup --reset-offsets --to-earliest --execute --topic $topic
fi

