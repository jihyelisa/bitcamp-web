package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"user.controller"})
public class Chapter04JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter04JpaApplication.class, args);
	}
}
