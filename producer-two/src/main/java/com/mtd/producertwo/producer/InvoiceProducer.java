package com.mtd.producertwo.producer;

import com.mtd.producertwo.entity.InvoiceCancelledMessage;
import com.mtd.producertwo.entity.InvoiceCreatedMessage;
import com.mtd.producertwo.entity.InvoicePaidMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* Demo for Multiple types messages handle
* Demo for consistent-hash-exchange với rounting key is invoiceNumber
* */
@Service
public class InvoiceProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	private static final String EXCHANGE = "x.invoice";

	public void sendInvoiceCreated(InvoiceCreatedMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, message.getInvoiceNumber(), message);
	}

	public void sendInvoicePaid(InvoicePaidMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, message.getInvoiceNumber(), message);
	}

	public void sendInvoiceCancelled(InvoiceCancelledMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, message.getInvoiceNumber(), message);
	}

}
