package com.fujitsu.trial_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TrialTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrialTaskApplication.class, args);
	}

}
