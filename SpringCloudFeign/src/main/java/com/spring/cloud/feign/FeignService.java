package com.spring.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.cloud.hystrix.HystrixFallbackFactory;
//@FeignClient(“服务名”)注解指定要调用的服务
@FeignClient(name = "cloud-server", fallbackFactory = HystrixFallbackFactory.class)
@Component
public interface FeignService {
	/***
	 *  @Description: 接口中的方法请求地址要和我们服务提供方的全部一致即可
	 *  @return
	 */
	@GetMapping("/getinfo")
    String getInfo();
}
