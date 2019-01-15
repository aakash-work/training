package com.miq.bootcamp.springboottraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringboottrainingApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringboottrainingApplication.class, args);
	}
}
