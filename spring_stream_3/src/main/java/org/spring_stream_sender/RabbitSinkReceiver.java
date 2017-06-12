package org.spring_stream_sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring_config_api.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class RabbitSinkReceiver {

	private static final Logger logger = LoggerFactory
			.getLogger(RabbitSinkReceiver.class);

//	@StreamListener(Processor.INPUT)
//	public void receiver(Object payload) {
//
//		logger.info("receiver payload: {}", payload);
//	}

	@StreamListener(Processor.INPUT)
	public void receiver2(String user) {

		logger.info("receiver2 payload: {}", user);
	}
}
