package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Main {

    public static void main(String[] args) {

        String csvFile = "src/main/resources/wine.csv";
        List<List<Double>> columns = new ArrayList<>(); //liste, die die Spalten enthalten soll

        try (Reader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                //hier wird durch jede reihe iteriert
                for (int i = 0; i < csvRecord.size(); i++) {
                    if (i >= columns.size()) {
                        columns.add(new ArrayList<Double>()); //fügt eine neue leere Liste für eine neue Spalte hinzu
                    }

                    String value = csvRecord.get(i);
                    double number = Double.parseDouble(value);
                    columns.get(i).add(number); //fügt die Zahl zur entsprechenden Spaltenliste colums hinzu
                  
                }
            }

        } catch (IOException e) {
            e.printStackTrace(); //wirft einen Stacktrace auf der Konsole aus, wenn der Pfad zur Datei ungültig ist
            System.out.println("Bitte überprüfe den Dateipfad!");
        }

        //Hier wird der Durchschnittswert für jede Spalte errechnet und ausgegeben
        for (int i = 0; i < columns.size(); i++) {
            List<Double> column = columns.get(i);
            double sum = 0;
            for (double number : column) {
                sum = sum + number; //Summe wird hier durch jeden Wert der Spalte erhöht
            }
            double average = sum / column.size(); //Durchschnitt berechnen
            System.out.println("Durchschnittswert für Spalte " + (i + 1) + ": " + average); //+1 damit es für menschen nachvollziehbar ist (sonst ist Spalte 1 die spalte 0 etc.
        }
    }
}
