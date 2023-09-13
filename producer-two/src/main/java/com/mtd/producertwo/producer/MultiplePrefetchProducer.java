package com.mtd.producertwo.producer;

import java.time.LocalTime;

import com.mtd.producertwo.entity.DummyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* Demo Multiple Prefetch value config via Java code
* */
@Service
public class MultiplePrefetchProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void simulateTransaction() {
		for (int i = 0; i < 20_000; i++) {
			var message = new DummyMessage("Transaction " + LocalTime.now(), i);
			rabbitTemplate.convertAndSend("x.transaction", "", message);
		}
	}
	
	public void simulateScheduler() {
		for (int i = 0; i < 200; i++) {
			var message = new DummyMessage("Scheduler " + LocalTime.now(), i);
			rabbitTemplate.convertAndSend("x.scheduler", "", message);
		}
	}
}
