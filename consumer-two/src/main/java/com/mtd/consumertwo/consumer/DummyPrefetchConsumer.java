package com.mtd.consumertwo.consumer;

import java.util.concurrent.TimeUnit;

import com.mtd.consumertwo.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/*
* Demo Prefetch consumer value config in application.yml
* */
//@Service
public class DummyPrefetchConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(DummyPrefetchConsumer.class);
	
	@RabbitListener(queues = "q.dummy", concurrency = "2")
	public void listenDummy(DummyMessage message) throws InterruptedException {
		LOG.info("Message is {}", message);
		TimeUnit.SECONDS.sleep(20);
	}
	
}
