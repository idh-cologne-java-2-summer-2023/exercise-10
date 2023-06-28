package idh.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Wine {

// Plan: Umwandlung von csv-Datei in HashMap. Key = Spalte; Value = Spalteninhalt. Dann Durchschnitt rechnen
	
	public static void main(String[] args) throws IOException {
				
		CSVParser csvParser = new CSVParser(new FileReader("src/main/resources/wine.csv"), CSVFormat.DEFAULT);
		
		HashMap<Integer, Double[]> wineHM = new HashMap<Integer, Double[]>();
			
		for(int i = 0; i < 12; i++ ) {
			wineHM.put(i, new Double[0]);
		}
		
// Fehler: The method replace(Integer, Double[]) in the type HashMap<Integer,Double[]> is not applicable for the 
// (int, String) noch nicht gelöst
// Nicht rechtzeitig gelöst. Plan oben. Die Funktion der String-Variablen in den csv-Funktionen nicht ganz verstanden
// und zu lange gebraucht, um zu merken, dass commons-io schon, aber commons-csv nicht importiert war.
		
// Versuch und Gedankenansatz unten. Auskommentiert, da nicht kompilierbar.
		
//		for (CSVRecord record : csvParser) {
//			wineHM.replace(0, record.get(0));
//			wineHM.replace(1, record.get(1));
//			etc
//		}
		

	}

}
