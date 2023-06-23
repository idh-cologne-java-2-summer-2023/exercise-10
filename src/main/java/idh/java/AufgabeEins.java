package idh.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ClassLoader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class AufgabeEins {

	public static void main(String[] args) throws IOException {
		double[] avg = new double[12];
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("wine.csv");
		InputStreamReader reader = new InputStreamReader(is,"UTF-8");
		
		for(CSVRecord record : CSVFormat.DEFAULT.parse(reader)) {
			for (int i = 0; i < 12; i++) {
				avg[i] += Double.parseDouble(record.get(i));
			}
		}
		
		for(int i = 0; i < 12; i++) {
			avg[i] = avg[i]/2000;
			System.out.println("Average " + (i + 1) + ": " + avg[i]);
		}
	}
	
}
