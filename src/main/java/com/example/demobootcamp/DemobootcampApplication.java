package com.example.demobootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.example.demobootcamp.model")
@SpringBootApplication
public class DemobootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemobootcampApplication.class, args);
	}

}
