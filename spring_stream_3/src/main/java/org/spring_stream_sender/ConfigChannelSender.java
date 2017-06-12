package org.spring_stream_sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(ConfigChannel.class)
public class ConfigChannelSender {

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigChannelSender.class);

	@Autowired
	private ConfigChannel configChannel;

	public void send(String message) {

		logger.info("ConfigChannel send message: {}", message);
		configChannel.output().send(MessageBuilder.withPayload(message).build());
	}
}
