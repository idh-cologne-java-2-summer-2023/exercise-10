package idh.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Wine {

	public static void main(String[] args) throws IOException {
		double Spalte1 = 0;
		double Spalte2 = 0;
		double Spalte3 = 0;
		double Spalte4 = 0;
		double Spalte5 = 0;
		double Spalte6 = 0;
		double Spalte7 = 0;
		double Spalte8 = 0;
		double Spalte9 = 0;
		double Spalte10 = 0;
		double Spalte11 = 0;
		double Spalte12 = 0;
		double Spalte13 = 0;
		Reader in = new FileReader("C:\\Users\\nikla\\git/exercise-10b/src/main/resources/wine.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		for (CSVRecord record : records) {
			 Spalte1 += Double.parseDouble(record.get(0));
			 Spalte2 += Double.parseDouble(record.get(1));
			 Spalte3 += Double.parseDouble(record.get(2));
			 Spalte4 += Double.parseDouble(record.get(3));
			 Spalte5 += Double.parseDouble(record.get(4));
			 Spalte6 += Double.parseDouble(record.get(5));
			 Spalte7 += Double.parseDouble(record.get(6));
			 Spalte8 += Double.parseDouble(record.get(7));
			 Spalte9 += Double.parseDouble(record.get(8));
			 Spalte10 += Double.parseDouble(record.get(9));
			 Spalte11 += Double.parseDouble(record.get(10));
			 Spalte12 += Double.parseDouble(record.get(11));
			
            
            
		}
		Spalte1 = Spalte1 / 2000;
		Spalte2 = Spalte2 / 2000;
		Spalte3 = Spalte3 / 2000;
		Spalte4 = Spalte4 / 2000;
		Spalte5 = Spalte5 / 2000;
		Spalte6 = Spalte6 / 2000;
		Spalte7 = Spalte7 / 2000;
		Spalte8 = Spalte8 / 2000;
		Spalte9 = Spalte9 / 2000;
		Spalte10 = Spalte10 / 2000;
		Spalte11 = Spalte11 / 2000;
		Spalte12 = Spalte12 / 2000;
		Spalte13 = Spalte13 / 2000;
		
		System.out.println(Spalte1);
		System.out.println(Spalte2);
		System.out.println(Spalte2);
		System.out.println(Spalte3);
		System.out.println(Spalte4);
		System.out.println(Spalte5);
		System.out.println(Spalte6);
		System.out.println(Spalte7);
		System.out.println(Spalte8);
		System.out.println(Spalte9);
		System.out.println(Spalte10);
		System.out.println(Spalte11);
		System.out.println(Spalte12);
	}

}
