package com.utstar.spring_feign;

import org.spring_config_api.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignClientInheritFallback implements IFeignClientInherit {

	@Override
	public String helloInherit() {

		return "hystrix fallback consumer2->hello4 return error!";
	}

	@Override
	public String helloInherit(@RequestParam("name") String name) {
		return "hystrix fallback consumer2->hello5 return error!";
	}

	@Override
	public String helloInherit(@RequestHeader("name") String name,
			@RequestHeader("age") Integer age) {
		return "hystrix fallback consumer2->hello6 return error!";
	}

	@Override
	public String helloInherit(@RequestBody User user) {
		return "hystrix fallback consumer2->hello7 return error!";
	}

}
