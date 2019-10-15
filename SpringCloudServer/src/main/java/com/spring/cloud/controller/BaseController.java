package com.spring.cloud.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.spring.cloud.config.IpConfiguration;
import com.spring.cloud.entity.User;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@PropertySource({"classpath:config/sys.properties","classpath:config/config.properties"})
public class BaseController {
	@Value("${config.user}")
	private String name;
	
	@Autowired
	IpConfiguration ip;

	@GetMapping(value = "/start")
	public String startServer() {
		log.info("访问该服务ip和端口 》》》》》》》》》》》》》》》》》》：" + getServerPort());
		return "server 启动了 ......";
	}
	
	@GetMapping(value = "/getinfo")
	public String getInfo() {
		log.info("访问该服务ip和端口 》》》》》》》》》》》》》》》》》》：" + getServerPort());
		//log.info("获取属性文件内容 ：" + name);
		User user = new User();
		user.setUser_name("admin");
		user.setSex(1);
		user.setCreate_time(new Date());
		user.setIs_del(0);
		String info = JSON.toJSONString(user);
		log.info("获取用户信息 》》》》：" + info);
		return info;
	}
	
	public String getServerPort() {
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (address != null) {
			String ipPort = address.getHostAddress() + ":" + ip.getPort();
			return ipPort;
		} else {
			return "";
		}
	}
}
