package com.utstar.spring_feign;

import org.spring_config_api.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CONFIG-SERVER", fallback = FeignClientFallback.class)
public interface IFeignClient {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String consumer();

	@GetMapping(value = "/hello1")
	public String consumer(@RequestParam("name") String name);

	@GetMapping(value = "/hello2")
	public String consumer(@RequestHeader("name") String name,
			@RequestHeader("age") Integer age);

	@PostMapping(value = "/hello3")
	public String consumer(@RequestBody User user);
}
