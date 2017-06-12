package org.spring_stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring_config_api.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class RabbitSinkReceiver {

	private static final Logger logger = LoggerFactory
			.getLogger(RabbitSinkReceiver.class);

	@StreamListener(Sink.INPUT)
	public void receiver(Object payload) {

		logger.info("receiver payload: {}", payload);
	}

	@StreamListener(Sink.INPUT)
	public void receiver2(User user) {

		logger.info("receiver2 payload: {}", user);
	}
}
