package com.mtd.producer.producer;

import java.io.IOException;

import com.mtd.producer.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Demo exchange with fanout mode
 * */
@Service
public class SpringEmployeeProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Employee data) throws IOException {
        var json = objectMapper.writeValueAsString(data);

        rabbitTemplate.convertAndSend("x.spring2.work", "", json);
    }

}