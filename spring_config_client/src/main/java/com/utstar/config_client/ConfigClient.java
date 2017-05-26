package com.utstar.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClient {

	// @Value("${foo}")
	// String foo;
	//
	// @RequestMapping(value = "/hi")
	// public String hi() {
	// return foo;
	// }

	@Value("${foo}")
	String foo;
	
	@Value("${client.foo}")
	String foo1;

	@RequestMapping("/hi")
	public String showLuckyWord() {
		return "The lucky word is: " + foo + " foo1: " + foo1;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}
}
