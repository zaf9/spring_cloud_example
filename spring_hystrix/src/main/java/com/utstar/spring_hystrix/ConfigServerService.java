package com.utstar.spring_hystrix;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConfigServerService {

	private static final Logger logger = LoggerFactory
			.getLogger(SpringHystrixApplication.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;

	
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello() {
		
		List<String> serviceList = discoveryClient.getServices();
		for (String serviceId : serviceList) {
			List<ServiceInstance> instanceList = discoveryClient
					.getInstances(serviceId);
			for (ServiceInstance instance : instanceList) {
				logger.info("consumer->hello serviceId: {} host: {} port: {} uri: {}",
						serviceId, instance.getHost(), instance.getPort(),
						instance.getUri());
			}

		}

		logger.info("hystrix consumer->hello!!! restTemplate: {}",
				restTemplate.getClass());
		
		return restTemplate.getForObject("http://config-server/hello",
				String.class);
	}
	
	public String helloFallback() {
		
		logger.info("helloFallback return error!");
		return "helloFallback error!";
	}
}
