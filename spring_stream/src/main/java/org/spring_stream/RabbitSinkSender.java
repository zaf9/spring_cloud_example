package org.spring_stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Source.class)
public class RabbitSinkSender {

	@Autowired
	private Source source;

	public void send(String message) {

		source.output().send(MessageBuilder.withPayload(message).build());
	}
}
