package idh.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Wine {

	public static void main(String[] args) throws IOException {
		Reader in = new FileReader("src/main/resources/wine.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		double d0 = 0, d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0, d7 = 0, d8 = 0, d9 = 0, d10 = 0, d11 = 0;

		for (CSVRecord record : records) {

			d0 += Double.parseDouble(record.get(0));
			d1 += Double.parseDouble(record.get(1));
			d2 += Double.parseDouble(record.get(2));
			d3 += Double.parseDouble(record.get(3));
			d4 += Double.parseDouble(record.get(4));
			d5 += Double.parseDouble(record.get(5));
			d6 += Double.parseDouble(record.get(6));
			d7 += Double.parseDouble(record.get(7));
			d8 += Double.parseDouble(record.get(8));
			d9 += Double.parseDouble(record.get(9));
			d10 += Double.parseDouble(record.get(10));
			d11 += Double.parseDouble(record.get(11));

		}

		System.out.println("Durchschnit Spalte 1 = " + d0 / 2000);
		System.out.println("Durchschnit Spalte 2 = " + d1 / 2000);
		System.out.println("Durchschnit Spalte 3 = " + d2 / 2000);
		System.out.println("Durchschnit Spalte 4 = " + d3 / 2000);
		System.out.println("Durchschnit Spalte 5 = " + d4 / 2000);
		System.out.println("Durchschnit Spalte 6 = " + d5 / 2000);
		System.out.println("Durchschnit Spalte 7 = " + d6 / 2000);
		System.out.println("Durchschnit Spalte 8 = " + d7 / 2000);
		System.out.println("Durchschnit Spalte 9 = " + d8 / 2000);
		System.out.println("Durchschnit Spalte 10 = " + d9 / 2000);
		System.out.println("Durchschnit Spalte 11 = " + d10 / 2000);
		System.out.println("Durchschnit Spalte 12 = " + d11 / 2000);

	}

}
