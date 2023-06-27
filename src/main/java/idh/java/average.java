package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class average {
	
	public static String csv = "C:\\Users\\erhan\\git\\exercise-10\\src\\main\\resources\\wine.csv";

	public static void main(String[] args)throws IOException {
		csvParser();

	}
	
	public static void csvParser()throws IOException {
		
		// Reading the wine.csv and parsing it 
		Reader reader = new FileReader(csv);
		CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
		
		// Number of Columns in the csv
		int numCols = -1;
		// Sum of Values in each Column
		double[] sumCols = null;
		
		for (CSVRecord record : csvParser) {
			if (numCols == -1) {
				numCols = record.size();
				sumCols = new double[numCols];
            }
			//Iterating over each Column and adding the Sum to the sumCol Array
			for (int i = 0; i < numCols; i++) {
				String value = record.get(i);
				double number = Double.parseDouble(value);
				sumCols[i] += number;
			}
		}
		// Dividing the sum of each column by the number of records in the csv
		long numRec = csvParser.getRecordNumber();
		double[] numColsAverage = new double[numCols];
		for (int i = 0; i < numCols; i++) {
			numColsAverage[i] = sumCols[i] /numRec;
		}
		System.out.println(Arrays.toString(sumCols));
		System.out.println(Arrays.toString(numColsAverage));
		
		csvParser.close();
		reader.close();
	}
	
}
