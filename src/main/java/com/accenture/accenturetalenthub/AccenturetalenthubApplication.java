package com.accenture.accenturetalenthub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.accenture.accenturetalenthub")
public class AccenturetalenthubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccenturetalenthubApplication.class, args);
	}

}
