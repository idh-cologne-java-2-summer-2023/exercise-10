package lina.schmitz;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Averages {
	public static void main(String[] args) {
		String csvFilePath = "src/main/resources/wine.csv";
        try {
            Reader read = new FileReader(csvFilePath);
            CSVParser csvParser = new CSVParser(read, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            for (String columnName : csvParser.getHeaderMap().keySet()) {
                double columnSum = 0;
                int rowCount = 0;
                for (CSVRecord csvRecord : csvParser) {
                    String cellValue = csvRecord.get(columnName);
                    try {
                        double value = Double.parseDouble(cellValue);
                        columnSum += value;
                        rowCount++;
                    } catch (NumberFormatException e) {
                    }
                }
                double columnAverage = columnSum / rowCount;
                System.out.println("Average " + columnName + ": " + columnAverage);
            }
            csvParser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
