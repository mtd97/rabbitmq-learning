package com.mtd.consumer.consumer;

import java.io.IOException;

import com.mtd.consumer.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.stereotype.Service;

/*
 * Demo Message Reject and go to DLX
 * */
@Service
public class MyPictureImageConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MyPictureImageConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        var picture = objectMapper.readValue(message, Picture.class);

        if (picture.getSize() > 9000) {
            channel.basicReject(tag, false);
            return;
//            throw new AmqpRejectAndDontRequeueException("Picture size too large : " + picture);
        }

        LOG.info("On image : {}", picture);
        //  Set ack manually in manual mode
        channel.basicAck(tag, false);
    }

}
