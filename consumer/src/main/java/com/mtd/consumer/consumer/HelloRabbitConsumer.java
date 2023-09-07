package com.mtd.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class HelloRabbitConsumer {

    @RabbitListener(queues = "mtd.hello")
    public void listen(String message) {
        System.out.println("Consuming " + message);
    }

}