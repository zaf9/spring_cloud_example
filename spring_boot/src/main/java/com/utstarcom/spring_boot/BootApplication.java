package com.utstarcom.spring_boot;

import java.util.Enumeration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootApplication {

	public static void main(String[] args) {
		System.getProperties().setProperty("spring.config.name", "application-boot");
		SpringApplication.run(BootApplication.class, args);
	}

	@RequestMapping("/hello")
	public String test() {

		return "Hello World!";
	}

	@RequestMapping("/")
	public String root() {

		Enumeration<Object> keys = System.getProperties().keys();
		StringBuilder result = new StringBuilder();
		while (keys.hasMoreElements()) {

			Object key = keys.nextElement();
			Object obj = System.getProperties().get(key);

			result.append(key + " : " + obj + "/r/n");

		}

		return result.toString();
	}
}
