package com.qihoo.study;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

import com.google.common.base.Joiner;

public class Test {
	
	
	public static void main(String[] args) {
		System.out.println(Test.class.getName());
//		Table<Integer, Integer, Object> table = HashBasedTable.create();
//		for(int i=0;i<10; ++i){
//			for(int j=0; j<10; ++j){
//				table.put(i, j, "i=" + i +", j=" + j);
//			}
//		}
//		System.out.println(table);
//		Joiner joiner = Joiner.on(":").useForNull("null");
//		UUID uid = null;
//		int i =0;
//		String str = joiner.join(uid, i);
//		String str2 = joiner.join("abc", uid);
//		System.out.println(str2);
//		BigDecimal b = new BigDecimal("7");
//		BigDecimal c = new BigDecimal("6");
//		BigDecimal d = b.divide(c,2, RoundingMode.HALF_UP);
//		System.out.println(d);
		String string = "abc#111";
		int index = string.lastIndexOf("#");
		String str1 = string.substring(0, index);
		String string2 = string.substring(index+1, string.length());
		System.out.println("str1: " + str1 + ", str2: " + string2);
		
	}
	
	public void testMethod(Address address, @Param("students")List<Student> studentList, Teacher teacher){
		System.out.println(studentList.get(0).getId());
	}
	
	public void testInt(int id){
		System.out.println(id);
	}
	
	public void testString(@Param("key")String key){
		System.out.println(key);
	}
	
	
}
