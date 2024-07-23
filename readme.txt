Curl

curl --request POST --header "Content-Type: application/json" --data '{"message": "hola crayola"}' http://localhost:8080/api/messages

Kafka Startup

bin/zookeeper-server-start.sh config/zookeeper.properties

bin/kafka-server-start.sh config/server.properties

bin/kafka-topics.sh --create --topic messages --bootstrap-server localhost:9092
bin/kafka-topics.sh --describe --topic messages --bootstrap-server localhost:9092

bin/kafka-console-consumer.sh --topic messages --from-beginning --bootstrap-server localhost:9092


bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic messages \
      --from-beginning --formatter kafka.tools.DefaultMessageFormatter \
      --property print.key=true --property print.value=true \
      --property key.deserialzer=org.apache.kafka.common.serialization.StringDeserializer \
      --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer


#This one prints the key value pair in the console
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic messages \
      --from-beginning --formatter kafka.tools.DefaultMessageFormatter \
      --property print.key=true --property print.value=true \
      --property key.deserialzer=org.apache.kafka.common.serialization.StringDeserializer