package idh.java;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;



public class wine {
	    public static void main(String[] args) {
	        try (FileReader Filereader = new FileReader("src/main/resources/wine.csv");
	             CSVParser csvParser = new CSVParser(Filereader, CSVFormat.DEFAULT)) {

	            boolean firstRow = true;
	            int numberOfColumns = 0;
	            int numberOfRows = 0;
	            double[] rowSums = new double[2000];

	            for (CSVRecord csvRecord : csvParser) {
	                if (firstRow) {
	                    numberOfColumns = csvRecord.size();
	                    firstRow = false;
	                } else {
	                    double rowSum = 0.0;

	                    for (int i = 0; i < numberOfColumns; i++) {
	                        String value = csvRecord.get(i);
	                        double numericValue = Double.parseDouble(value);
	                        rowSum += numericValue;
	                    }

	                    rowSums[numberOfRows] = rowSum;
	                    numberOfRows++;
	                }
	            }

	            System.out.println("Durchschnittswerte:");
	            for (int i = 0; i < numberOfRows; i++) {
	                double rowAverage = rowSums[i] / numberOfColumns;
	                System.out.println("Zeile " + (i + 1) + ": " + rowAverage);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
