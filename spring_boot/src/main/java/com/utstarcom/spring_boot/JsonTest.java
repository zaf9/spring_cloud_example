package com.utstarcom.spring_boot;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

public class JsonTest {

	private static final Logger logger = LoggerFactory
			.getLogger(JsonTest.class);

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {

		Gson gson = new Gson();

		Student student = new Student();
		student.id = 1;
		student.nickName = "乔晓松";
		student.age = 22;
		student.email = "965266509@qq.com";

		List<String> books = new ArrayList<String>();
		books.add("haha");
		books.add("tlbb");
		books.add("sgyy");
		student.books = books;

		Map<String, String> booksMap = new HashMap<String, String>();
		booksMap.put("1", "1");
		booksMap.put("2", "3");
		booksMap.put("3", "3");
		student.booksMap = booksMap;

		logger.info("gson toJson student: {}", gson.toJson(student));

		String strJson = gson.toJson(student);
		student = gson.fromJson(strJson, Student.class);

		logger.info("gson student fromJson toString: {}", student.toString());

		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.setSerializationInclusion(Include.NON_EMPTY);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		mapper.writeValue(output, student);
		logger.info("jackson student writevalue: {}", output.toString());

		ByteArrayInputStream input = new ByteArrayInputStream(
				output.toByteArray());
		student = mapper.readValue(input, Student.class);
		logger.info("jackson student readvalue: {}", student.toString());

	}

}

class Student {
	public int id;
	public String nickName;
	public int age;
	public List<String> books;
	public Map<String, String> booksMap;
	public String email;

	@Override
	public String toString() {
		return "Student [id=" + id + ", nickName=" + nickName + ", age=" + age
				+ ", books=" + books + ", booksMap=" + booksMap + ", email="
				+ email + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
