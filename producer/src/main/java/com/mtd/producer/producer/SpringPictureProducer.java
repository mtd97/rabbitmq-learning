package com.mtd.producer.producer;

import java.io.IOException;

import com.mtd.producer.entity.Picture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
* Demo for spring simple retry
* */
@Service
public class SpringPictureProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void sendMessage(Picture picture) throws IOException {
		var json = objectMapper.writeValueAsString(picture);
		rabbitTemplate.convertAndSend("x.spring.work", picture.getType(), json);
	}
	
}
