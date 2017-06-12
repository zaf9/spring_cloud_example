package org.spring_stream_sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Processor.class)
public class RabbitSinkSender {

	private static final Logger logger = LoggerFactory
			.getLogger(RabbitSinkSender.class);

	@Autowired
	private Processor processor;

	public void send(String message) {

		logger.info("send message: {}", message);
		processor.output().send(MessageBuilder.withPayload(message).build());
	}
}
