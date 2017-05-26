package com.utstar.spring_feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("CONFIG-SERVER")
public interface IFeignClient {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String consumer() ;

}
