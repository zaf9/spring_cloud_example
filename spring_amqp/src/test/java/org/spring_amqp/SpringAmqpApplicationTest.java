package org.spring_amqp;

import java.util.Timer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpApplicationTest {

	@Autowired
	private RabbitSender sender;

	@Test
	public void test() throws InterruptedException {
		while (true) {
			this.sender.send();
			Thread.sleep(1000);
		}
	}

}
