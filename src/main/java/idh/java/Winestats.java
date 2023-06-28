package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
//couldn't finish on time

public class Winestats {
	public static void main(String[] args) throws IOException {
		double[] column = new double[12];
		double rows = 2000;

		// accessing column values by index
		String csvWine = "src/main/resources/wine.csv";
		Reader in = new FileReader(csvWine);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

		// TO DO: rewrite for-loop -> dynamic access to index
		for (CSVRecord record : records) {
			for (int i = 0; i < 12; i++) {
				// casting String to double []
				// column = record.get(i);
				// System.out.println(column);
			}
		}
		for (int i = 0; i < 12; i++) {
			// column[]/rows
			System.out.println("Durchschnitt ist: "/* + column[] */);
		}

	}

}