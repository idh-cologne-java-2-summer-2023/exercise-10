package idh.java;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ClassLoader;

public class Winestats {
	public static void main(String[] args) throws IOException {
		
		// accessing column values by index
		String csvWine = "src/main/resources/wine.csv";
		Reader in = new FileReader(csvWine);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
		
		// TO DO: rewrite for-loop/dynamic index
		for (CSVRecord record : records) {
			String column = record.get(0);
		}
		//thanks, stackoverflow
		

	}

}