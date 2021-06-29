# CardCoupon

## start sql:
```
mysql.server start
```

## start Kafka:
```
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

## create topic
```
bin/kafka-topics.sh --create --topic merchants-template --bootstrap-server localhost:9092
```

## see topic describe
```
bin/kafka-topics.sh --describe --topic merchants-template --bootstrap-server localhost:9092
```

## start consumer console
```
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic merchants-template --from-beginning
```
