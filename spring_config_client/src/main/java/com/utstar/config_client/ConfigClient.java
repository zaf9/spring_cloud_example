package com.utstar.config_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
@Configuration
@PropertySource(value = "file:${user.dir}/src/main/config/test.properties")
public class ConfigClient {

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigClient.class);

	// @Value("${foo}")
	// String foo;
	//
	// @RequestMapping(value = "/hi")
	// public String hi() {
	// return foo;
	// }

	@Value("${foo}")
	String foo;

	// @Value("${client.foo}")
	// String foo1;

	@Value("${my.test.value}")
	int myValue;

	@Value("${my.yml.test.value}")
	String myYmlValue;

	@Value("${my.yml.test2.value}")
	String myYmlValue2;

	@RequestMapping("/hi")
	public String showLuckyWord() {
		logger.info("my test value: {}", myValue);
		logger.info("my yml test value: {}", myYmlValue);
		logger.info("my yml test2 value: {}", myYmlValue2);
		return "The lucky word is foo: " + foo;
	}

	// sping cloud bus bug:
	// http://blog.csdn.net/ityouknow/article/details/72841460
	// --server.port=9999
	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}
}
