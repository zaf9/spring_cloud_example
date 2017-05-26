package com.utstar.spring_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaApplication {

	//--spring.profiles.active=peer1
	//--spring.profiles.active=peer2
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaApplication.class, args);
	}
}
