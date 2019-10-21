package com.spring.cloud.hystrix;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.feign.FeignService;

import feign.hystrix.FallbackFactory;
@Component
public class HystrixFallbackFactory implements FallbackFactory<FeignService> {

	@Override
	public FeignService create(Throwable cause) {
		return new FeignService() {
			/**
             * @访问getInfo方法出现异常后的熔断处理方法
             */
			@SuppressWarnings("static-access")
			@Override
			public String getInfo() {
				JSONObject json = new JSONObject();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("code", 400);
				map.put("msg", "调用方法出现异常后，进行熔断处理");
				map.put("success", false);
				map.put("exception", cause.getMessage());
				return json.toJSONString(map);
			}
		};
	}

}
