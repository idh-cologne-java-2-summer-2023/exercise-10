package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;



public class Wine {

	public static void main(String[] args) throws IOException {
	
		//Ausgabe Durchschnitte aller Spalten:
		for (int i = 0; i < 12;i++) {
			doubleAverageColumn("src/main/resources/wine.csv", i);
		}
		
	}
	
	
	public static void doubleAverageColumn(String csvFile, int columnIndex) throws IOException {
		
		Reader in = new FileReader(csvFile);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		
		ArrayList<Double> columnList = new ArrayList<Double>(); // Liste zum Zwischenspeichern ganzer Spalten
		
		double columnSum = 0;
		
		for (CSVRecord record : records) {
		    String column = record.get(columnIndex);
		    columnList.add(Double.parseDouble(column));
		    columnSum = columnSum + Double.parseDouble(column); //Zwischenberechnung der Summe aller Elemente
		}
		
		double columnAvg = columnSum / (double)columnList.size(); //Berechnung Durchschnitt
		
		//System.out.println(columnSum);
		
		System.out.println("The average for the column with the index " + columnIndex + " is: " + columnAvg);
		System.out.println();
	}

}
