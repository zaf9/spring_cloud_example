package com.utstar.spring_hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
public class SpringHystrixApplication {

	private static final Logger logger = LoggerFactory
			.getLogger(SpringHystrixApplication.class);

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	ConfigServerService csservice;

	@RequestMapping(value = "/consumer", method = RequestMethod.GET)
	public String consumer() {

		logger.info("consumer -> csservice.hello( )");

		return csservice.hello();
	}

	//--server.port=9994 --spring.application.name=hystrix-consumer-2
	public static void main(String[] args) {
		SpringApplication.run(SpringHystrixApplication.class, args);
	}

}
