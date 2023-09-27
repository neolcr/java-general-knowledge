#!/bin/bash

/Users/enol/Documents/apache-activemq-5.18.2/bin/activemq producer --user admin --password admin --broker-url tcp://localhost:61616 --destination topic://TopicAA --message "Message A"