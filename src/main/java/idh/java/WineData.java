package idh.java;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class WineData {
    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        double[] columnSums = new double[12];
        int rowCount = 0;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("wine.csv");
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        for (CSVRecord record : CSVFormat.DEFAULT.parse(reader)) {
            for (int i = 0; i < 12; i++) {
                columnSums[i] += Double.parseDouble(record.get(i));
            }
            rowCount++;
        }

        double[] columnAverages = new double[12];
        for (int i = 0; i < 12; i++) {
            columnAverages[i] = columnSums[i] / rowCount;
            System.out.println("Average for column " + (i + 1) + ": " + columnAverages[i]);
        }
    }
}

