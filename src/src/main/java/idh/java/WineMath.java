package src.main.java.idh.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;



public class WineMath {

	public static void main(String[] args) throws FileNotFoundException {

		Reader in = new FileReader("main.resources/wine.csv");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		for (CSVRecord record : records) {
		}
		
		
	}

}