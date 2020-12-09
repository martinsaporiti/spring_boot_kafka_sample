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


