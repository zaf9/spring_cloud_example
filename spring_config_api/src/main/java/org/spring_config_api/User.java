package org.spring_config_api;

public class User {

	public String name;
	public Integer age;

	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
