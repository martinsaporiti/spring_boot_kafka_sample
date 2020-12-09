# Producer and Consumer with Spring Boot

## Summary
This prototype shows how to configure a producer and a consumer with spring boot

We can configure the example by modifying the application.properties file:

```
#Brokers urls list:
bootstrap.servers.config=192.168.0.152:9092, 192.168.0.152:9093, 192.168.0.152:9094

#Topic to produce:
producer.topic=myTopic

#Topic to consume:
consumer.topics=myTopic
```

## Testing
We can test running the app:

```
./mvnw spring-boot:run
```

Next, we can send messages to API:

```
curl --location --request POST 'localhost:8080/api/kafka/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "field1": "test 1",
    "field2": "test 2"
}'
```

Now, if we can view in the terminal the messages, the app has worked fine:
```bash
Receiving message: Model{field1='test 1', field2='test 2'}
```

