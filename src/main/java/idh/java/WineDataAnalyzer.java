package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class WineDataAnalyzer {
    public static void main(String[] args) {
        String csvFilePath = "src/main/resources/wine.csv";

        try (Reader reader = new FileReader(csvFilePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            int numColumns = records.iterator().next().size();
            double[] columnSums = new double[numColumns];

            for (CSVRecord record : records) {
                for (int i = 0; i < numColumns; i++) {
                    double cellValue = Double.parseDouble(record.get(i));
                    columnSums[i] += cellValue;
                }
            }

            int numRows = (int) records.spliterator().getExactSizeIfKnown();
            System.out.println("Number of rows: " + numRows);

            System.out.println("Average of each column:");
            for (int i = 0; i < numColumns; i++) {
                double columnAverage = columnSums[i] / numRows;
                System.out.println("Column " + i + ": " + columnAverage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
