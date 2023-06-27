package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Wine {

	public static void main(String[] args) {
		String csvFile = "src/main/resources/wine.csv";
		
		//Liste für die Daten der CSV Datei
		List<List<Double>> columnValue = new ArrayList<List<Double>>();
		
		//CSV Datei wird eingelesen
		try(BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
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
			
			//Berechnung des Durchschnitts 
			double average = calculateAverage (values1);
			System.out.println("Der Durchschnitt für die Spalte " + (i1 + 1) + " beträgt: " + average);
			}
			
			}} catch (IOException e) {
			e.printStackTrace();
		}
	}
			//Definition des Durchschnitts
			private static double calculateAverage (List<Double> values) {
			double sum = 0.0;
			for (Double value : values) { sum += value;
			}
			return sum / values.size();
		}
	}

