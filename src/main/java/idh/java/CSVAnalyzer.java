package idh.java;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CSVAnalyzer {
    // Main method to calculate column averages
    public static void main(String[] args) throws IOException {
        // Specify the path to the wine.csv file
        String csvFilePath = "src/main/resources/wine.csv";
        
        // Create a new CSVParser using the specified file path
        try (Reader reader = new FileReader(csvFilePath)) {
            CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader();
            CSVParser csvParser = new CSVParser(reader, csvFormat);
            
            // Get the CSV headers/column names
            String[] headers = csvParser.getHeaderMap().keySet().toArray(new String[0]);

            // Create a map to store column totals and counts
            Map<String, Double> columnTotals = new HashMap<>();
            Map<String, Integer> columnCounts = new HashMap<>();
            
            // Iterate over each record/row in the CSV file
            for (CSVRecord record : csvParser) {
                // Iterate over each column in the current record
                for (String header : headers) {
                    // Get the value of the current column for the current record
                    String value = record.get(header);
                    
                    // Convert the value to a double
                    double numericValue = Double.parseDouble(value);
                    
                    // Update the column total and count
                    columnTotals.put(header, columnTotals.getOrDefault(header, 0.0) + numericValue);
                    columnCounts.put(header, columnCounts.getOrDefault(header, 0) + 1);
                }
            }
            
            // Calculate and display the averages for each column
            for (String header : headers) {
                double columnAverage = columnTotals.get(header) / columnCounts.get(header);
                System.out.println(header + ": " + columnAverage);
            }
        }
    }
}