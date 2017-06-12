package org.spring_amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class RabbitReceiver {

	private static final Logger logger = LoggerFactory
			.getLogger(RabbitReceiver.class);

	@RabbitHandler
	public void process(String context) {

		logger.info("receiver context: {}", context);
	}

}
