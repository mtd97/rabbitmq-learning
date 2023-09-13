package com.mtd.producertwo.producer;

import com.mtd.producertwo.entity.DummyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class AnotherDummyProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendDummy(DummyMessage message) {
		rabbitTemplate.convertAndSend("x.another-dummy", "", message);
	}
	
}
