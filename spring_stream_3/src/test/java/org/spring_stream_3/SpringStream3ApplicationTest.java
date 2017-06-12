package org.spring_stream_3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring_stream_sender.ConfigChannelSender;
import org.spring_stream_sender.RabbitSinkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringStream3ApplicationTest {

	@Autowired
	RabbitSinkSender sender;
	
	@Autowired
	ConfigChannelSender configSender;

	@Test
	public void test() throws InterruptedException {

		int i = 0;
		while (true) {
			++i;
//			this.sender.send("{\"name\": \"totti\", \"age\": 40}");
			this.configSender.send("{\"name\": \"daniele de rossi\", \"age\": 33}");
			Thread.sleep(1000);
		}
	}

}
