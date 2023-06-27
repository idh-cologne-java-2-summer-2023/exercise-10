package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Wine {
	
	public static void main(String[] args) throws IOException {
		
		for (int column = 0; column < 12; column++) {
			doubleAverageColumn("src/main/resources/wine.csv", column);
		}
		
	}

	private static void doubleAverageColumn(String string, int column) throws IOException {
		Reader in = new FileReader("src/main/resources/wine.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		
		for (CSVRecord record : records) {
			
		    String csvColumn = record.get(column);
		    
		    String firstName = record.get("First Name");
		}
		
	}
//Due to terrible time management, I wasn't able to finish this one properly. Sorry 'bout that.
}
