package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.*;

public class CsvReaderClass {
	
	public void readFile() throws IOException {
		Reader in = new FileReader("src/main/resources/wine.csv");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		double[] values = new double[12];
		int counter = 0;
		for (CSVRecord record : records) {
		    for(int i=0; i<record.size(); i++){
		    	values[i] += Double.parseDouble(record.get(i));
		    	counter++;
		    }
		}
		for(int i=0; i<values.length; i++) {
			values[i] /= counter;
			System.out.println("Durchschnitt von Wert Nummer " + i + ": " + values[i]);
		}  
	}
	
	public static void main(String[] args) throws IOException {
		CsvReaderClass r = new CsvReaderClass();
		r.readFile();
	}
}