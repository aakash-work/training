package com.miq.bootcamp.SpringbootTraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(scanBasePackages= {"com.miq.*"})
@EnableJpaRepositories
public class SpringbootTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrainingApplication.class, args);
	}

}

