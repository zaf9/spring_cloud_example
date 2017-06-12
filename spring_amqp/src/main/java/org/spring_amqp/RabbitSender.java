package org.spring_amqp;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {

	private static final Logger logger = LoggerFactory.getLogger(RabbitSender.class);
	
	@Autowired
	AmqpTemplate amqpTemplate;
	
	public void send() {
		
		String context = "hello: "+ new Date();
		logger.info("send context: {}",context);
		this.amqpTemplate.convertAndSend("hello", context);
		
	}
}
