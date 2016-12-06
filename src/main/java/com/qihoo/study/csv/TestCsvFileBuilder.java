package com.qihoo.study.csv;

import java.util.HashMap;
import java.util.Map;

public class TestCsvFileBuilder {
	public static void main(String[] args) {
		
		Map<String, String> idName = new HashMap();
		idName.put("1", "Java");
		idName.put("2", "C++");
		idName.put("3", "Python");
		idName.put("4", "Ruby");
		
		CsvFileBuilder.write(idName);
	}
}
