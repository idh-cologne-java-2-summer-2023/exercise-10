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
		// initialize the variables
		String path = "src/main/resources/wine.csv";
		List<Double> values = new ArrayList();
		int ncol = 0;
		int nrow = 0;

		// start reader and parser
		Reader input = new FileReader(path);
		CSVParser parser = CSVFormat.DEFAULT.parse(input);

		// all values are saved to a list and the number of columns and rows are counted
		for (CSVRecord item : parser) {
			ncol = item.size();
			for (int i = 0; i <= ncol - 1; i++) {
				values.add(Double.parseDouble(item.get(i)));
			}
		}
		nrow = (int) parser.getRecordNumber();

		// loop for the calculation and output of the average of the columns
		for (int i = 0; i <= ncol - 1; i++) {
			final DecimalFormat decimal = new DecimalFormat("0.00");
			double sum = values.get(i);
			int columnNR = i + 1;
			double counter = 0;
			while (counter <= nrow) {
				sum += values.get(i + ncol);
				counter++;
			}
			System.out.println("Der Durchschnitt von Spalte " + columnNR + " ist: " + decimal.format(sum / nrow));
		}

		input.close();
		parser.close();

	}

}
