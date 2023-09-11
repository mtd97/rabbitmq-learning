package com.mtd.producer;

import com.mtd.producer.entity.Employee;
import com.mtd.producer.producer.EmployeeJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
//@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Autowired
    private EmployeeJsonProducer producer;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            var employee = new Employee("emp" + i, "Rizi", LocalDate.of(1990, 12, i + 1));
            producer.sendMessage(employee);
        }
    }
}
