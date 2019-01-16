package com.miq.boot.springboottraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.miq.*"})
@EnableJpaRepositories("com.miq.*")
@EntityScan("com.miq.*")
public class SpringboottrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottrainingApplication.class, args);
	}

}

