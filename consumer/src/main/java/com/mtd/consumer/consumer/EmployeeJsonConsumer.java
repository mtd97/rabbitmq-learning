package com.mtd.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.mtd.consumer.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

/*
 * Json Messages Demo with Jackson
 * */
@Service
public class EmployeeJsonConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    @RabbitListener(queues = "course.employee")
    public void listen(String message) throws IOException {
        var employee = objectMapper.readValue(message, Employee.class);

        LOG.info("Employee is {}", employee);
    }

}
