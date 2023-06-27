package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class main {
    public static void main(String[] args) {
        try {
            Reader in = new FileReader("src/main/resources/wine.csv");
            
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            double[] columns = {0,0,0,0,0,0,0,0,0,0,0,0};
            int size = 0;
            for (CSVRecord record : records) {
                String[] values = record.values();
                int c = 0;
                for (String value : values) {
                    columns[c] += Double.parseDouble(value);
                    c++;
                }
                size++;
            }
            int s = 0;
            for (Double c : columns) {
                columns[s] = c / size;
                System.out.println("Durchscnitt Spalte " + s + " ist: " + columns[s]);
                s++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
