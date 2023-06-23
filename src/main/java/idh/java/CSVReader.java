package idh.java;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {
	ArrayList<Float> contentsOfOneColumn = new ArrayList<Float>();
	Reader reader;
	CSVParser csvparser;
	
	public CSVReader(String path) throws IOException {
		reader = Files.newBufferedReader(Paths.get(path));
		csvparser = new CSVParser(reader, CSVFormat.DEFAULT);
	}

	public ArrayList<Float> readColumn(int column) throws IOException{
		contentsOfOneColumn.clear();	

		for (CSVRecord csvrecord : csvparser) {
			float content = Float.parseFloat(csvrecord.get(column));
			contentsOfOneColumn.add(content);
		}
		csvparser.close();
		return contentsOfOneColumn;
	}
	
}
