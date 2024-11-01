package com.peliculasydirectores.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.peliculasydirectores")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
