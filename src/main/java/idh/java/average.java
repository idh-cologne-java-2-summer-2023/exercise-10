package idh.java;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.FileReader;
import java.io.IOException;

public class average {

	public static void main(String[] args) {
		String csvFile = "src/main/resources/wine.csv";
        try {
            FileReader fileReader = new FileReader(csvFile);
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL);

            for (CSVRecord record : csvParser) {
                double Summe = 0.0;
                int Zeile = record.size();
                for (int i = 0; i < Zeile; i++) {
                    double Wert = Double.parseDouble(record.get(i));
                    Summe += Wert;
                }
                double Durchschnitt = Summe / Zeile;
                System.out.println("Durchschnitt Zeile" + record.getRecordNumber() + ": " + Durchschnitt);
            }

            csvParser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	}

