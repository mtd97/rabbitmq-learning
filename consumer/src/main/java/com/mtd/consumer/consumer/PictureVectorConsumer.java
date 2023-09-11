package com.mtd.consumer.consumer;

import java.io.IOException;

import com.mtd.consumer.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

/* Demo exchange with direct mode
 * If images are svg q.picture.vector receive it and processing
 * */
@Service
public class PictureVectorConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(PictureVectorConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "q.picture.vector")
    public void listen(String message) throws IOException {
        var picture = objectMapper.readValue(message, Picture.class);
        LOG.info("On vector : {}", picture);
    }

}
