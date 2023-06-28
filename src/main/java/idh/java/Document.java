package idh.java;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class Document {
    public static void main(String[] args) throws IOException {
        File csvFile = new File("src/main/resources/wine.csv");
        List<String> lines = FileUtils.readLines(csvFile, "UTF-8");

        String headerLine = lines.get(0);
        String[] headers = headerLine.split(",");
        
        double[] sumArray = new double[headers.length];
        Arrays.fill(sumArray, 0.0);

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] values = line.split(",");

            for (int j = 0; j < values.length; j++) {
                double value = Double.parseDouble(values[j]);
                sumArray[j] += value;
            }
        }

        int rowCount = lines.size() - 1;
        double[] averageArray = new double[sumArray.length];
        for (int i = 0; i < averageArray.length; i++) {
            averageArray[i] = sumArray[i] / rowCount;
        }

        for (int i = 0; i < averageArray.length; i++) {
            System.out.printf("Column %d average: %.2f\n", (i + 1), averageArray[i]);
        }
    }
}