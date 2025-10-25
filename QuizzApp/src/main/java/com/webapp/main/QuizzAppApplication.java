package com.webapp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.webapp")
@EnableJpaRepositories("com.webapp.dao")      // scans JPA repositories
@EntityScan("com.webapp.beans")
public class QuizzAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzAppApplication.class, args);
	}

}
