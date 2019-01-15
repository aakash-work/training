package com.miq.bootcamp.sprintboottraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.miq.*"})
@EnableJpaRepositories("com.miq.*")
@EntityScan("com.miq.*")
public class SprintboottrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintboottrainingApplication.class, args);
	}

}

