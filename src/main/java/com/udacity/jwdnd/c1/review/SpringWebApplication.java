package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
	/*
	 * @Bean public String message() { System.out.println("message created"); return
	 * "Hello, Spring!"; }
	 * 
	 * @Bean public String uppercaseMessage(MessageService messageService) {
	 * System.out.println("upper case message created"); return
	 * messageService.toUppercase(); }
	 * 
	 * @Bean public String lowercaseMessage(MessageService messageService) {
	 * System.out.println("lower case message created"); return
	 * messageService.toLowercase(); }
	 */
}
