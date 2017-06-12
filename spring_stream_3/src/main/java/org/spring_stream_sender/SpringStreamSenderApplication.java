package org.spring_stream_sender;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

import io.netty.channel.ChannelConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringStreamSenderApplication {

	private final AtomicInteger i = new AtomicInteger();

//	@Bean
//	@InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "2000"))
//	public MessageSource<String> sendMessageSource() {
//		return () -> new GenericMessage<>("{\"name\": \"totti\", \"age\": 40}");
//	}

	@Bean
	@InboundChannelAdapter(value = ConfigChannel.OUTPUT, poller = @Poller(fixedDelay = "2000"))
	public MessageSource<String> channelMessageSource() {
		return () -> new GenericMessage<>("numbers: "
				+ this.i.incrementAndGet()
				+ " {\"name\": \"daniele de rossi\", \"age\": 33}");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringStreamSenderApplication.class, args);
	}
}
