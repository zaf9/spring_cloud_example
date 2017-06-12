package org.spring_stream_receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.config.BindingServiceProperties;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(ConfigChannel.class)
public class ConfigChannelReceiver {

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigChannelReceiver.class);
	
	@Value("${server.port}")
	String port;

	@StreamListener(ConfigChannel.INPUT)
	@SendTo(ConfigChannel.OUTPUT)
	public String receiver2(String user) {

		logger.info("ConfigChannel receiver payload: {}", user);
		return "port: " + port + " ConfigChannel From input Channel return: " + user;
	}
}
