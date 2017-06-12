package com.utstar.spring_feign;

import org.spring_config_api.IConfigServer;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "CONFIG-SERVER", fallback = FeignClientInheritFallback.class)
public interface IFeignClientInherit extends IConfigServer {

}
