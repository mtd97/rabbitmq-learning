package com.mtd.producer.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtd.producer.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/*
 * Json Messages Demo with Jackson
 * */
@Service
public class EmployeeJsonProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Employee data) throws IOException {
        var json = objectMapper.writeValueAsString(data);

        rabbitTemplate.convertAndSend("course.employee", json);
    }

}