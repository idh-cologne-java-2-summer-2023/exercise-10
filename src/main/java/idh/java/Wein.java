package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;



public class Wein {

	public static void main(String[] args) throws IOException {
	
		
		for (int i = 0; i < 12;i++) {
			a("src/main/resources/wine.csv", i);
		}
		
	}
	
	public static void a(String csvFile, int columnIndex) throws IOException {
		
		Reader in = new FileReader(csvFile);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		
		ArrayList<Double> Liste = new ArrayList<Double>(); 
		double Summe = 0;
		
		for (CSVRecord record : records) {
		    String column = record.get(columnIndex);
		    Liste.add(Double.parseDouble(column));
		    Summe = Summe + Double.parseDouble(column);
		}
		
		double columnAvg = Summe / (double)Liste.size();
		
		
		System.out.println("Der Durchschnitt " + columnIndex + " ist: " + columnAvg);
		System.out.println();
	}

}