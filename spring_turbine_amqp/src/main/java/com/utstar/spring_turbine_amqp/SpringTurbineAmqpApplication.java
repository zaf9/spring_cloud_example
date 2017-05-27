package com.utstar.spring_turbine_amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class SpringTurbineAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTurbineAmqpApplication.class, args);
	}

}
