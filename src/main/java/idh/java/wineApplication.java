package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class wineApplication {

	public static void main(String[] args) {
		String csvFilePath = "src/main/resources/wine.csv";

        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {

            int columnCount = -1;
            BigDecimal[] columnSums = null;
            int rowCount = 0;

            for (CSVRecord csvRecord : csvParser) {
                if (columnCount == -1) {
                    columnCount = csvRecord.size();
                    columnSums = new BigDecimal[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        columnSums[i] = BigDecimal.ZERO;
                    }
                }

                for (int i = 0; i < columnCount; i++) {
                    String cellValue = csvRecord.get(i);
                    try {
                        BigDecimal value = new BigDecimal(cellValue);
                        columnSums[i] = columnSums[i].add(value);
                    } catch (NumberFormatException e) {
                    	//Alles außer Zahlen ignorieren
                    }
                }

                rowCount++;
            }

            if (rowCount > 0) {
                for (int i = 0; i < columnCount; i++) {
                    BigDecimal average = columnSums[i].divide(BigDecimal.valueOf(rowCount), 2, RoundingMode.HALF_UP);
                    System.out.println("Durchschnitt Spalte " + (i + 1) + ": " + average);
                }
            } else {
                System.out.println("Die CSV-Datei ist leer.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
