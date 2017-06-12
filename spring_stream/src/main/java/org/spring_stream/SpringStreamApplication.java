package org.spring_stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringStreamApplication {	

	public static void main(String[] args) {
		SpringApplication.run(SpringStreamApplication.class, args);
	}
}
