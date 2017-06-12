package com.utstar.config_server;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring_config_api.IConfigServer;
import org.spring_config_api.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigServerController implements IConfigServer {

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigServerController.class);

	@Override
	public String helloInherit() {
		int sleepTime = new Random().nextInt(10000);
		logger.info("hello4->sleepTime: {}", sleepTime);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello4 World!";
	}

	@Override
	public String helloInherit(@RequestParam("name") String name) {
		return "hello5 " + name;
	}

	@Override
	public String helloInherit(@RequestHeader("name") String name,
			@RequestHeader("age") Integer age) {
		return "hello6 " + new User(name, age).toString();
	}

	@Override
	public String helloInherit(@RequestBody User user) {
		return "hello7 " + user;
	}

}
