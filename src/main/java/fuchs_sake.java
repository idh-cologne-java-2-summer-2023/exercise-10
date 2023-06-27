import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class fuchs_sake {

	public static void main(String[] args) throws IOException {
//Reader:
	    Reader reader = new FileReader("src/main/resources/wine.csv");
        CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
	        
//Numbers:
//Number of Columns: 
        int numCol = -1; //for statistical reasons this has to be -1
// Sum of each Column:      
        double[] sumCol = null; 
//Time to count:
       for(CSVRecord record: csvParser) {
    	   if(numCol == -1) {
    		   numCol = record.size();
    		   sumCol = new double[numCol];
    	   }
       
//Time to iterate:
    	   for (int i = 0; i< numCol; i++) {
    		   String value = record.get(i);
    		   double number = Double.parseDouble(value);
    		   sumCol[i] += number;
    	   }
    	   }
       
       
//Time for Math:
	long numRec = csvParser.getRecordNumber();
	double[] numColAv = new double [numCol];
	for (int i = 0; i < numCol; i++ ) {
		numColAv[i] = sumCol[i] /numRec;
	}
	System.out.println(Arrays.toString(sumCol));
	System.out.println(Arrays.toString(numColAv));
	
//Closing time
	csvParser.close();
	reader.close();
	}
	}


	


