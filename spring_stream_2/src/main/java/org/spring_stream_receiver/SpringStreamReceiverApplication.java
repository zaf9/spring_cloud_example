package org.spring_stream_receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringStreamReceiverApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringStreamReceiverApplication.class, args);
	}
}
