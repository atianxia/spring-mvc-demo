package com.qihoo.study;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BeanUtilsTest {

	static String jsonString = "{\"name\":\"Mahesh\", \"id\":\"21\",\"address\":{\"address1\":\"address1\", \"address2\":\"address2\"}, \"students\":[{\"id\":\"1\", \"name\":\"student1\"}]}";
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, IllegalAccessException, InvocationTargetException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		
		Map<String, Object> map =  objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
		});
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(teacher, map);
		System.out.println(teacher.getAddress().getAddress1());
	}
}
