package idh.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Wine {
	public static void main(String[] args) throws IOException {
		WineProgram program = new WineProgram();
		program.run();
		
		
	}
	private static class WineProgram{
		void run() throws IOException {
			csvgügsler(0);
		}
		void csvgügsler(int row) throws IOException {
			int columnSize = 0;
			double columnValue = 0;
			String output = "";
			Reader in = new FileReader("src/main/resources/wine.csv");
			try {
				Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
				
				for (CSVRecord record : records) {
					columnValue += Double.parseDouble(record.get(row));
					columnSize ++;
					output = "Der Durschnitt der Spalte "+row+" ist "+ columnValue/columnSize;
				}
				System.out.println(output);
				if(row < 11) {
					csvgügsler(row+1);
				};
			}
			finally {
				in.close();
			};
			
	}
  }
}
