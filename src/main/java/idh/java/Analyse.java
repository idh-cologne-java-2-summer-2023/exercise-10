package idh java;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Analyse {
    public static void main(String[] args) {
        String csvFilePath = "src/main/resources/wine.csv";

        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(fileReader)) {

            String[] headers = csvParser.getHeaderMap().keySet().toArray(new String[0]);

            
            List<List<Double>> columns = new ArrayList<>();
            for (int i = 0; i < headers.length; i++) {
                columns.add(new ArrayList<>());
            }

            
            for (CSVRecord record : csvParser) {
                for (int i = 0; i < headers.length; i++) {
                    String value = record.get(headers[i]);
                    double doubleValue = Double.parseDouble(value);
                    columns.get(i).add(doubleValue);
                }
            }

           
            for (int i = 0; i < headers.length; i++) {
                List<Double> column = columns.get(i);
                double sum = 0;
                for (double value : column) {
                    sum += value;
                }
                double average = sum / column.size();
                System.out.println("Durchschnitt für " + headers[i] + ": " + average);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

