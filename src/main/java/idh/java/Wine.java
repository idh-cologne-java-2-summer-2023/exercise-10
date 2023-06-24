package idh.java;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.*;

public class Wine {


	public static void main(String[] args) throws IOException {
		Reader wine = new FileReader("src/main/resources/wine.csv");
		CSVParser parser = CSVParser.parse(wine, CSVFormat.RFC4180);
		for (CSVRecord csvRecord : parser) {
			int i = 0;
		    double val = 0;
		    for (String field : csvRecord) {
		    	double fieldValue = returnDouble(field);
		    	val = val + fieldValue;
		    	i++;
		    }
		    System.out.println(val/i);
		    System.out.println();
		}

	}
	
	

	public static double returnDouble(String object) {
		return Double.parseDouble(object);
	}

}
