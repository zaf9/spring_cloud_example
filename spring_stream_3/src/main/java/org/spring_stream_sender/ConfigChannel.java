package org.spring_stream_sender;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ConfigChannel {

	String OUTPUT = "configChannelOutput";
	String INPUT = "configChannelInput";

	@Output(ConfigChannel.OUTPUT)
	MessageChannel output();

	@Input(ConfigChannel.INPUT)
	SubscribableChannel input();
}
