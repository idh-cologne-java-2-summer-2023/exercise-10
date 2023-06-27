package durchschnitt;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Durchschnitt {

	public static void main(String[] args) {
		double columns;
		double values;
		
		try {
		Reader in = new FileReader("src/main/resources/wine.csv");
		CSVParser records = CSVFormat.EXCEL.withHeader().parse(in);
		for (String header : records.getHeaderNames()) {
			columns = 0;
			values = 0;
			
			for (CSVRecord record : records) {
			values = values + Double.parseDouble(record.get(header));
			columns++;
			}
			System.out.println(values/columns);
		}	
		} catch (IOException e) {
			
		}
	}

}
