package com.miq_bootcamp.springboot_training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringbootTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrainingApplication.class, args);
	}

}

