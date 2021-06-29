# CardCoupon Merchants side Application
This is the subsystem for Merchant side.
You can run the application

# Requirements
For building and running the application you need:

<a href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">JDK 1.8</a>
<a href="https://maven.apache.org/">Maven</a>
mySQL
Kafka

# Start background services
## start and log into sql:
```
mysql.server start
mysql -u root -p
```
create database and table:
```
CREATE DATABASE passbook;
USE passbook;
```
## create database
run command
```
CREATE TABLE `merchants`(
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'Name of Merchant',
    `logo_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'logo of Merchant',
    `business_license_url` varchar(256 ) COLLATE utf8_bin NOT NULL COMMENT 'complement license of Merchant',
    `phone` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'Contact Phone',
    `address` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'Contact Address',
    `is_audit` BOOLEAN COLLATE utf8_bin NOT NULL COMMENT 'Is audited or not',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
```
you can also find this in *resources/merchants.sql*

## start Kafka:
```cd your/kafka/dir/libexec```

execute:
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

# Running the project
There are several ways to run a Spring Boot application on your local machine.

One way is to execute the main method in
*the src/main/java/com/cardcoupon/passbook/MerchantsApplication.java*
class from your IDE.

another way is to run:
```
mvn clean install
mvn spring-boot:run
```

## url request
1. get merchants from database
```
http://localhost:9527/merchants/{id}
```
#### example:
![img_2.png](img_2.png)


2. create merchants
### get merchants from database
```
http://localhost:9527/merchants/create
```
#### example:
```
{
    "name": "Amazon",
    "logoUrl": "www.amazon.com",
    "businessLicenseUrl": "www.amazon.com",
    "phone": "909-000-1111",
    "address": "San Diego,CA"
}
```
![img_3.png](img_3.png)

there should be new records in mysql database.
![img_4.png](img_4.png)

3. drop template
### get merchants from database
```
http://localhost:9527/merchants/create
```
#### example:
```
{
    "background":3,
    "desc":"this is a coupoun for vitamins",
    "end":1626665870000,
    "hasToken":false,
    "id":11,
    "limit":10000,
    "start":1623209872000,
    "summary":"Summary: vitamin coupoun for CVS",
    "title":"CVS Vitamin 2021"
}
```
there shoule be new templates in KAFKA
![img_6.png](img_6.png)
![img_5.png](img_5.png)