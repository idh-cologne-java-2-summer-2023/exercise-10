package idh.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;




public class Main {

    //CSV file location
    static String csvFileLocation = "src/main/resources/wine.csv";

    //integer marking the number of columns -1 to account for the 0 row
    static int numberOfRows = 12 - 1;

    public static void main(String[] args) throws IOException {
        WineCSV program = new WineCSV();

        program.run();

    }

    private static class WineCSV {

        void run() throws IOException {

            csvMedianCal(0);

        }

        void csvMedianCal(int row ) throws IOException {

            Reader in = new FileReader(csvFileLocation);

            String consolePrintStream = "";

            double columValue = 0; //summ of all individual values from one colum
            int columSize = 0; //length of the colum

            try {

                Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);


                for (CSVRecord record : records) {

                    columValue  += Double.parseDouble(record.get(row));

                    columSize ++;

                    consolePrintStream = "Die Summe der Spalte "
                            + row
                            + " beträgt: "
                            +  columValue /columSize;

                }

                System.out.println("Colum-size: " + columSize + " of colum " + row + ".");
                System.out.println(consolePrintStream);

                if(row == numberOfRows ){

                    System.out.println(" ");
                    System.out.println("Process finished with " + row + " checked columns.");

                } else {

                    csvMedianCal(row +1);

                }

            } catch (FileNotFoundException e) {

                throw new RuntimeException(e);

            } catch (IOException e) {

                throw new RuntimeException(e);

            } finally {

                in.close();

            }
        }
    }


}
