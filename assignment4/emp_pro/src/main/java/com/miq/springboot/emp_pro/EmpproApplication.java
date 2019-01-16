package com.miq.springboot.emp_pro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
public class EmpproApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(EmpproApplication.class, args);

	}

}
