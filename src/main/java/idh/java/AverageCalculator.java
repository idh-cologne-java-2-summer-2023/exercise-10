package idh.java;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class AverageCalculator {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/wine.csv";
        try (FileReader reader = new FileReader(csvFile);
             CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(reader)) {

            for (String header : csvParser.getHeaderNames()) {
                double columnSum = 0;
                int rowCount = 0;

                for (CSVRecord csvRecord : csvParser) {
                    double cellValue = Double.parseDouble(csvRecord.get(header));
                    columnSum += cellValue;
                    rowCount++;
                }

                double columnAverage = columnSum / rowCount;
                System.out.println("Average for column " + header + ": " + columnAverage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
