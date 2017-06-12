package org.spring_config_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface IConfigServer {

	@RequestMapping(value = "/hello4", method = RequestMethod.GET)
	public String helloInherit();

	@GetMapping(value = "/hello5")
	public String helloInherit(@RequestParam("name") String name);

	@GetMapping(value = "/hello6")
	public String helloInherit(@RequestHeader("name") String name,
			@RequestHeader("age") Integer age);

	@PostMapping(value = "/hello7")
	public String helloInherit(@RequestBody User user);
}
