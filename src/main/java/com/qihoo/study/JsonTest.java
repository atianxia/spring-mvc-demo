package com.qihoo.study;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	static String jsonString = "{\"name\":\"Mahesh\", \"id\":\"21\", \"students\":[{\"id\":\"1\", \"name\":\"student1\"}]}";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		/*
		 * Teacher teacher = new Teacher(); teacher.setId("1");
		 * teacher.setName("aba"); List<Student> students = new ArrayList<>();
		 * Student student1 = new Student(); student1.setId("1");
		 * student1.setName("student1"); Student student2 = new Student();
		 * student2.setId("2"); student2.setName("student2");
		 * students.add(student1); students.add(student2);
		 * teacher.setStudents(students );
		 */

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.readTree(jsonString).get("students").toString();
		TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {
		};
		List<Student> students = objectMapper.readValue(json,
				new TypeReference<List<Student>>() {
				});
		Teacher teacher = objectMapper.readValue(jsonString, Teacher.class);
		System.out.println(teacher.getId());

	}
}
