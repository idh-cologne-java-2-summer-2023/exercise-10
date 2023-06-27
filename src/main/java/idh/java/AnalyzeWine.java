package idh.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Es wurde nur Aufgabe 1 bearbeitet 
public class AnalyzeWine {

    public static void main(String[] args) {
        String csvFile = "src/main/resources/wine.csv"; // Pfad zur wine.csv-Datei wird angepasst 

        //Liste für die Daten der CSV Datei 
        List<List<Double>> columnValue = new ArrayList<List<Double>>();

        //Hier soll die CSV Datei gelesen werden
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean firstLine = true;

            //Erste Zeile mit Spaltenname wird übersprungen
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Erste Zeile mit Spaltennamen wird übersprungen
                }

                //Hier werden Werte aufgeteilt
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    double numericValue = Double.parseDouble(values[i].trim()); 

                    if (columnValue.size() <= i) {
                        columnValue.add(new ArrayList<Double>());
                    }

                    columnValue.get(i).add(numericValue);
                }

                //Double Werte sollen ausgegeben werden
            for (int i1 = 0; i1 < columnValue.size(); i1++) {
                List<Double> values1 = columnValue.get(i1);
                //Hier soll der Durchschnitt ausgerechnet und anschließend ausgegeben werden
                double average = calculateAverage(values1);
                System.out.println("Durchschnitt für Spalte " + (i1 + 1) + ": " + average);
            }

            }} catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Hier wird der Durschschnitt definiert 
    private static double calculateAverage(List<Double> values) {
        double sum = 0.0;
        for (Double value : values) {
            sum += value;
        }
        return sum / values.size();
    }
        }
    
