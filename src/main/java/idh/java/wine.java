package idh.java;
import java.io.Reader;
import java.io.StringReader;
import java.commons.csv.io;


public class wine {
    //Todo: Implement
    //first let´s get this damn csv thing read

    Reader in = new StringReader("a,b,c");
 for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
     for (String field : record) {
         System.out.print("\"" + field + "\", ");
     }
 }

}
