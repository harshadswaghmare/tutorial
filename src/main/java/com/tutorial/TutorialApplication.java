package com.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.annotations.Test;

@SpringBootApplication

public class TutorialApplication {
@Test(priority=0)
	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);

	}

}
