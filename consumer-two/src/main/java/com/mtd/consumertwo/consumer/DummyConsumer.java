package com.mtd.consumertwo.consumer;

import com.mtd.consumertwo.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/*
 * Demo auto convert message when receive in queue with Jackson2JsonMessage
 * */
@Service
public class DummyConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(DummyConsumer.class);

    @RabbitListener(queues = "q.dummy")
    public void listenDummy(DummyMessage message) {
        LOG.info("Message is {}", message);
    }

}
