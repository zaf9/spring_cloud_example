package com.utstar.config_server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConfigServer {

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigServer.class);

	@Autowired
	private DiscoveryClient client;

	// https://segmentfault.com/a/1190000006138698
	// --server.port=9995
	// --server.port=9996
	public static void main(String[] args) {

		SpringApplication.run(ConfigServer.class, args);
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String test() {

		@SuppressWarnings("deprecation")
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/hello, host: {}, service_id: {}", instance.getHost(),
				instance.getServiceId());
		return "Hello World!";
	}
}
