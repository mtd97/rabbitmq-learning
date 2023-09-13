package com.mtd.producertwo;

import com.mtd.producertwo.entity.DummyMessage;
import com.mtd.producertwo.producer.AnotherDummyProducer;
import com.mtd.producertwo.producer.DummyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private DummyProducer producer;

    @Override
    public void run(String... args) throws Exception {
        var dummyMessage = new DummyMessage("Just a dummy message", 1);
        producer.sendDummy(dummyMessage);
    }

}
