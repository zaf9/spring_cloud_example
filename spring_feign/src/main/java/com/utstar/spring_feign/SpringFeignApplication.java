package com.utstar.spring_feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SpringFeignApplication {

	private static final Logger logger = LoggerFactory
			.getLogger(SpringFeignApplication.class);

	@Autowired
	IFeignClient feignClient;

	@RequestMapping(value = "/consumer", method = RequestMethod.GET)
	public String consumer() {

		return feignClient.consumer();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignApplication.class, args);
	}

}
