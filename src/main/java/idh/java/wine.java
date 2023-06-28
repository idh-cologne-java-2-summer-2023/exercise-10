package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class wine {
	public static CSVParser loader(String s) throws IOException {
		CSVParser records;
		FileReader in = new FileReader(s);
		records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		return records;
	}
	
	public static double average(CSVParser records, int column) {
		double sum = 0;
		int count = 0;
		
		for(CSVRecord record : records) {
			double value = Double.parseDouble(record.get(column));
			sum = value + sum;
			count++;
		}
		
		return sum / count;
	}
	
	public static List<Double> averageAll(String s) throws IOException {
		int columnCount = loader(s).getHeaderNames().size();
		List<Double> sum = new ArrayList<Double>();
		
		for(int i = 0; i < columnCount; i++) {
			sum.add(average(loader(s), i));
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		List<Double> i = averageAll("src/main/resources/wine.csv");
		System.out.println(i);
	}
}
