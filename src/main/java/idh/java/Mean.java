package idh.java;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.*;

public class Mean {

	public static void main(String[] args) throws IOException {
		Reader r = new FileReader("src/main/resources/wine.csv");
		CSVParser p = new CSVParser(r, CSVFormat.DEFAULT);
		Iterable<CSVRecord> records = p.getRecords();
		int spaltenNummer = 0;
		float sum = 0.0f;
		
		while(spaltenNummer < 12) {
			int i = 0;
			sum = 0.0f;
			for (CSVRecord csvRecord : records) {
				sum += Float.parseFloat(csvRecord.get(spaltenNummer));
				i++;
			}
			System.out.println("Durchschnitt von Spalte " + (spaltenNummer + 1) + " ist " + sum/i);
			spaltenNummer++;
			}
		
		p.close();

	}

}
