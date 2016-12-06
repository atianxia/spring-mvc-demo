package com.qihoo.study.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CsvFileBuilder {
	
	private static final String[] header = { "id", "dfdsf","name"};
	
	private static FileWriter fileWriter = null;
	private static CSVPrinter csvPrinter = null;
	private static CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator('\n');  // 每条记录间隔符
	
	public static void write(Map<String, String> info) {
		File file = new File("test.csv");	
		try {					
			fileWriter = new FileWriter("test.csv",true);  // 创建test.csv的字符输出流		
			csvPrinter = new CSVPrinter(fileWriter, csvFormat);
			
				csvPrinter.printRecord(header);  // 生成.csv表的字段名

			Set<String> ids = info.keySet();			
			for (String id : ids) {
				List<String> idName = new ArrayList();
				idName.add(id);
				idName.add(info.get(id));
				csvPrinter.printRecord(idName);  // 向.csv文件中添加记录数据
			}
			csvPrinter.printRecord(new String[]{"sdfdsfds","dsfsdfds", "dsfdsfdsfds"});
			csvPrinter.print("fdsfdsf");
			System.out.println("生成.csv文件");
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				csvPrinter.flush();
				fileWriter.flush();				
				fileWriter.close();	
				csvPrinter.close();	
			}catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
	}
}
