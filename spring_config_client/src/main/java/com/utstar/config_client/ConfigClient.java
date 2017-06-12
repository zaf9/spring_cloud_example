package com.utstar.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
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
	
//	@Value("${client.foo}")
//	String foo1;

	@RequestMapping("/hi")
	public String showLuckyWord() {
		return "The lucky word is foo: " + foo;
	}

	//sping cloud bus bug: http://blog.csdn.net/ityouknow/article/details/72841460
	//--server.port=9999
	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}
}
