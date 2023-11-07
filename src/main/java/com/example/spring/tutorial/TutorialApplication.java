package com.example.spring.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.spring.tutorial.config.ContentProperties;


@EnableConfigurationProperties(ContentProperties.class)
@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

}
