package idh.java;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class main {

	public static void main(String[] args) {

        String csvFile = "src/main/resources/wine.csv";
        List<List<Double>> columns = new ArrayList<>(); 

        try (Reader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            for (CSVRecord csvRecord : csvParser) {
                
                for (int i = 0; i < csvRecord.size(); i++) {
                    if (i >= columns.size()) {
                        columns.add(new ArrayList<Double>()); 
                    }

                    String value = csvRecord.get(i);
                    double number = Double.parseDouble(value);
                    columns.get(i).add(number); 
                    
                    
                  
                }
            }

}
