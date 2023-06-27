package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Wine {

	public static void main(String[] args) throws IOException {

		String path = "src/main/resources/wine.csv";
		List<Double> values = new ArrayList();
		int ncol = 0;
		int nrow = 0;

		Reader input = new FileReader(path);
		CSVParser parser = CSVFormat.DEFAULT.parse(input);

		for (CSVRecord item : parser) {
			ncol = item.size();
			for (int i = 0; i <= ncol - 1; i++) {
				values.add(Double.parseDouble(item.get(i)));
			}
		}

		nrow = (int) parser.getRecordNumber();
		for (int i = 0; i <= ncol - 1; i++) {
			sum(i, nrow, ncol, values);
		}

		input.close();
		parser.close();

	}

	public static void sum(int start, int max, int step, List<Double> values) {
		final DecimalFormat decimal = new DecimalFormat("0.00");
		double sum = values.get(start);
		int columnNR = start + 1;
		double counter = 0;
		while (counter <= max) {
			sum += values.get(start + step);
			counter++;
		}
		System.out.println("Durchschnitt der Spalte " + columnNR + " ist: " + decimal.format(sum/ max) );
	}

}
