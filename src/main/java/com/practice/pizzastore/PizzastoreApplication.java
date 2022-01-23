package com.practice.pizzastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PizzastoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzastoreApplication.class, args);
	}

}
