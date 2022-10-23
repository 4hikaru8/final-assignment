package com.it_seisan.try_event.tryeve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TryeveApplication {

	public static void main(String[] args) {
		SpringApplication.run(TryeveApplication.class, args);
	}

}
