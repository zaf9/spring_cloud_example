package com.utstar.spring_ribbon;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringRibbonApplication {

	private static final Logger logger = LoggerFactory
			.getLogger(SpringRibbonApplication.class);

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/consumer", method = RequestMethod.GET)
	public String consumer() {

		List<String> serviceList = discoveryClient.getServices();
		for (String serviceId : serviceList) {
			List<ServiceInstance> instanceList = discoveryClient
					.getInstances(serviceId);
			for (ServiceInstance instance : instanceList) {
				logger.info("consumer serviceId: {} host: {} port: {} uri: {}",
						serviceId, instance.getHost(), instance.getPort(),
						instance.getUri());
			}

		}

		logger.info("ribbon consumer!!! restTemplate: {}",
				restTemplate.getClass());

		return restTemplate.getForObject("http://config-server/hello",
				String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRibbonApplication.class, args);
	}

}
