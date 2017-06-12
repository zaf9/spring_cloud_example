package com.utstar.spring_feign;

import org.spring_config_api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SpringFeignApplication {

	@Autowired
	IFeignClient feignClient;

	@Autowired
	IFeignClientInherit feignClientInherit;

	@RequestMapping(value = "/consumer", method = RequestMethod.GET)
	public String consumer() {

		return feignClient.consumer();
	}

	@GetMapping(value = "/consumer1")
	public String consumer1() {

		return new StringBuilder().append(feignClient.consumer()).append("\n")
				.append(feignClient.consumer("Totti")).append("\n")
				.append(feignClient.consumer("德罗西", 34)).append("\n")
				.append(feignClient.consumer(new User("Buffon", 99)))
				.toString();
	}

	@GetMapping(value = "/consumer2")
	public String consumer2() {

		return new StringBuilder()
				.append(feignClientInherit.helloInherit())
				.append("\n")
				.append(feignClientInherit.helloInherit("Totti"))
				.append("\n")
				.append(feignClientInherit.helloInherit("德罗西", 34))
				.append("\n")
				.append(feignClientInherit.helloInherit(new User("Buffon", 99)))
				.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignApplication.class, args);
	}

}
