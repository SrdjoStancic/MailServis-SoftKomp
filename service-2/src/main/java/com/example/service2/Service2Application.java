package com.example.service2;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Service2Application {

//	@Autowired
//	private ConfigurableApplicationContext ctx;

	@Bean
	Queue queue(){ return  new Queue("mailEvents"); }

	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}

}
