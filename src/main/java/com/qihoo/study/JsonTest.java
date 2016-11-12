package com.qihoo.study;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonTest {
	static String jsonString = "{\"name\":\"Mahesh\", \"id\":\"21\",\"address\":{\"address1\":\"address1\", \"address2\":\"address2\"}, \"students\":[{\"id\":\"1\", \"name\":\"student1\"}]}";
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static void main1(String[] args)
			throws JsonParseException, JsonMappingException, IOException, NoSuchMethodException, SecurityException {
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
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.setDateFormat(new SimpleDateFormat(DATE_FORMAT));

		Teacher teacher = objectMapper.readValue(jsonString, Teacher.class);
		System.out.println(teacher.getStudents());
		String json = objectMapper.readTree(jsonString).get("students").toString();
		TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {
		};
		List<Student> students = objectMapper.readValue(json, new TypeReference<List<Student>>() {
		});
		Class<?> abc = List.class;
		Method[] methods = Test.class.getDeclaredMethods();
		Method method = null;
		for (Method m : methods) {
			if (m.getName().equals("testMethod")) {
				method = m;
				break;
			}
		}
		Class<?> class1 = method.getParameterTypes()[0];
		Type superClass = class1.getClass().getGenericSuperclass();
		Type _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
		// Teacher teacher = objectMapper.readValue(jsonString, Teacher.class);
		// System.out.println(teacher.getId());
		//
	}

	public static void main2(String[] args) throws JsonProcessingException, IOException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method[] methods = Test.class.getDeclaredMethods();
		Method method = null;
		for (Method m : methods) {
//			if (m.getName().equals("testMethod")) {
				if (m.getName().equals("testString")) {
				method = m;
				break;
			}
		}
		Parameter[] parameters = method.getParameters();
		Object[] params = new Object[parameters.length];
		for (int i = 0; i < parameters.length; i++) {

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Parameter parameter = parameters[i];
			Param param = parameter.getAnnotation(Param.class);
			String parameterName;
			if (param == null) {
				parameterName = parameter.getName();
			} else {
				parameterName = param.value();
			}

			 JsonNode jsonNode = objectMapper.readTree(json).get(parameterName);
             String paramValueJson;
             if(jsonNode == null){
                 if(param != null){
                     params[i] = null;
                     continue;
                 } else {
                     paramValueJson = json;
                 }
             }else {
                 paramValueJson = jsonNode.toString();
             }
			if (parameter.getParameterizedType() instanceof ParameterizedType) {
				ParameterizedType type = (ParameterizedType) parameter.getParameterizedType();
				Class<?>[] actualTypeArguments = new Class<?>[type.getActualTypeArguments().length];
				for (int j = 0; j < actualTypeArguments.length; j++) {
					actualTypeArguments[j] = (Class<?>) type.getActualTypeArguments()[j];
				}
				JavaType javaType = objectMapper.getTypeFactory().constructParametricType((Class<?>) type.getRawType(),
						actualTypeArguments);
				params[i] = objectMapper.readValue(paramValueJson, javaType);
			} else {
				params[i] = objectMapper.readValue(paramValueJson, parameter.getType());
			}
		}

		method.invoke(new Test(), params);
	}
	public static void main(String[] args) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			objectMapper.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
	 System.out.println(objectMapper.writeValueAsString(args));
	}
	
	private static String document = "{document:\"{propertySemaTypes {id, name, icon, description, baseType} }\"}";
	
	private static String json = "{\"command\":\"import_status\"}";

}
