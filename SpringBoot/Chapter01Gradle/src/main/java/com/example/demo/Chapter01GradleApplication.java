package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.controller",
							   "board.controller"})
public class Chapter01GradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter01GradleApplication.class, args);
	}
}
