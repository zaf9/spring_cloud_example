package org.spring_stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringStreamApplicationTest {

	@Autowired
	RabbitSinkSender sender;

	@Test
	public void test() throws InterruptedException {

		int i = 0;
		while (true) {
			++i;
			this.sender.send("{\"name\": \"totti\", \"age\": 40}");
			Thread.sleep(1000);
		}
	}

}
