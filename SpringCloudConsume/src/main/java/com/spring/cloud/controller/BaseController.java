package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BaseController {
	@Autowired
    RestTemplate restTemplate;
	
    @RequestMapping(value = "/consumer",method = RequestMethod.GET)
    public String helloController() {
    	
        return restTemplate.getForEntity("http://cloud-server/getinfo", String.class).getBody();
    }
}
