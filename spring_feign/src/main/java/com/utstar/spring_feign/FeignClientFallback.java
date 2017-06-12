package com.utstar.spring_feign;

import org.spring_config_api.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignClientFallback implements IFeignClient {


	@Override
	public String consumer() {
		
		return "hystrix fallback consumer1->hello return error!";
	}

	@Override
	public String consumer(@RequestParam("name") String name) {
		
		return "hystrix fallback consumer1->hello1 return error!";
	}

	@Override
	public String consumer(@RequestHeader("name") String name,
			@RequestHeader("age") Integer age) {
		
		return "hystrix fallback consumer1->hello2 return error!";
	}

	@Override
	public String consumer(@RequestBody User user){
		
		return "hystrix fallback consumer1->hello3 return error!";
	}

}
