package idh.java;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvAverage {

    public static CSVParser CsvLoader (String f) throws IOException {
        CSVParser records;
            Reader in = new FileReader(f);
            records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);

        return records;
    }
    public static double ColumnAverage (CSVParser records, int columnName) {
        double sum = 0;
        int count = 0;

        for (CSVRecord record : records) {
            double value = Double.parseDouble(record.get(columnName));
           sum= value + sum;
            count++;
        }

        sum = sum / count;

        return sum;
    }

    public static List<Double> AllColumnAverage(String s) throws IOException {
        int columnCount = CsvLoader(s).getHeaderNames().size();
        List<Double> sum = new ArrayList<Double>();

        for (int i = 0; i < columnCount; i++) {
            sum.add(ColumnAverage(CsvLoader(s), i));
        }
     return sum;
    }
    public static void main(String[] args) throws IOException {
        List<Double> i = AllColumnAverage("src/main/resources/wine.csv");
        System.out.println(i);

    }
}

