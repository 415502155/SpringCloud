package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.serviceinterface.FeignService;

@RestController
public class BaseController {
	@Autowired 
	private FeignService feignService;
	
	@GetMapping("/go")
    public String callFeignServer(){
        return feignService.getInfo();
    }
	@GetMapping("/test")
    public String test(){
        return "Hello World!!!!!";
    }
}
