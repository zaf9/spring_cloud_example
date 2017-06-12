package com.utstar.config_server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring_config_api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.JGitEnvironmentRepository;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableConfigServer
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConfigServer{

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigServer.class);

	@Autowired
	private DiscoveryClient client;

	@Autowired
	JGitEnvironmentRepository repository;

	@Autowired
	WebMvcAutoConfigurationAdapter configuration;

	// https://segmentfault.com/a/1190000006138698
	// --server.port=9995
	// --server.port=9996
	public static void main(String[] args) {

		SpringApplication.run(ConfigServer.class, args);
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() throws InterruptedException {

		int sleepTime = new Random().nextInt(10000);
		logger.info("hello->sleepTime: {}", sleepTime);
		Thread.sleep(sleepTime);

		// @SuppressWarnings("deprecation")
		// ServiceInstance instance = client.getLocalServiceInstance();
		// logger.info("/hello, host: {}, service_id: {}", instance.getHost(),
		// instance.getServiceId());
		return "Hello World!";
	}

	@GetMapping(value = "/hello1")
	public String hello(@RequestParam String name) throws InterruptedException {

		return "hello1 " + name;
	}

	@GetMapping(value = "/hello2")
	public String hello(@RequestHeader String name, @RequestHeader Integer age)
			throws InterruptedException {

		return "hello2 " + new User(name, age).toString();
	}

	@GetMapping(value = "/download")
	public void download(@RequestParam String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		// String fileName = uri.replace("//", "/").substring(uri.indexOf("/",
		// 2));
		logger.info("url: {} uri: {} fileName: {}", url, uri, fileName);

		String label = request.getParameter("label");
		if (label == null)
			label = "master";

		this.repository.refresh(label);

		String localDir = this.repository.getBasedir().getAbsolutePath();
		String localFile = localDir + "/" + fileName;
		logger.info("localDir: {} localFile: {}", localDir, localFile);

		File file = new File(localFile);
		if (!file.exists() || !file.isFile()) {
			response.sendError(404, "the config file: " + fileName
					+ " don't exist!");
			return;
		}

		long fileLen = file.length();
		response.setContentType("text/xml");
		response.setContentLengthLong(fileLen);

		try (InputStream inputStream = new FileInputStream(file);
				OutputStream outputStream = response.getOutputStream()) {

			byte[] readBytes = new byte[4096];
			while (inputStream.read(readBytes) != -1)
				outputStream.write(readBytes);
		}
	}

	@PostMapping(value = "hello3")
	public String hello(@RequestBody User user) throws InterruptedException {

		return "hello3 " + user;
	}
}
