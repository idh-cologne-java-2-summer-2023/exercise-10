package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class WineAverages {

	public static void main(String[] args) throws IOException {
		// prepare reading in the file
		Reader in = new FileReader("src/main/resources/wine.csv");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
		
		// array of 12 doubles to sum up the values
		double[] sums = new double[12];
		
		// count the number of rows in the table
		int counter = 0;
		
		// iterate over each row, and sum up each column
		for (CSVRecord record : records) {
			for (int i = 0; i < record.size(); i++) {
				sums[i] += Double.valueOf(record.get(i));
			}
			counter++;
		}
		
		// Print out and divide by the number of rows
		System.out.println("Means: ");
		for (int i = 0; i < sums.length; i++) {
			System.out.println(" " + String.valueOf(i) + ": " + String.valueOf(sums[i]/counter));
		}
		     
	}

}
