package com.gaspricetracker.gaspricetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GasPriceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasPriceTrackerApplication.class, args);
	}

}
