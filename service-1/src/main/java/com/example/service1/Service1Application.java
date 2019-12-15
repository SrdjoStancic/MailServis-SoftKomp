package com.example.service1;

import com.example.service1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Service1Application {

//	@Autowired
//	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);

	}

}
