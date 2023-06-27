
public class AverageCalculator {
	import org.apache.commons.csv.CSVFormat;
	import org.apache.commons.csv.CSVParser;
	import org.apache.commons.csv.CSVRecord;

	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	public class AverageCalculator {

	    public static void main(String[] args) {
	        String csvFilePath = "C:\\Users\\totro\\git\\exercise-10\\src\\main\\resources\\wine.cvs"; 

	        try (FileReader reader = new FileReader(csvFilePath);
	             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

	            List<List<Double>> columns = new ArrayList<>();

	            for (CSVRecord csvRecord : csvParser) {
	                int columnCount = csvRecord.size();

	                for (int i = 0; i < columnCount; i++) {
	                    String cellValue = csvRecord.get(i);

	                    if (i >= columns.size()) {
	                        columns.add(new ArrayList<>());
	                    }

	                    
	                    try {
	                        double value = Double.parseDouble(cellValue);
	                        columns.get(i).add(value);
	                    } catch (NumberFormatException e) {
	                    
	                    }
	                }
	            }

	            for (List<Double> column : columns) {
	                double sum = 0.0;
	                for (Double value : column) {
	                    sum += value;
	                }
	                double average = sum / column.size();
	                System.out.println("Durchschnitt: " + average);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
