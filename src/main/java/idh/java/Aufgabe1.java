package idh.java;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;


public class Aufgabe1<E> extends AbstractList<E>{

public static void main(String[] args) throws FileNotFoundException, IOException {
	for(int i=0; i<12; i++ ) 
	{getfile(i);
		}
}

public static void getfile(int columeindex) throws FileNotFoundException, IOException {
	LinkedList<Double> linkedList = new LinkedList<Double>();
//relative file path not working, tried (/exercise-10/src/main/resources/wine.csv) used absolute path,
    String csvFile = "C:\\Users\\Laurent\\git\\exercise-10\\src\\main\\resources\\wine.csv";
    try (Reader reader = new FileReader(csvFile);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
    			for (CSVRecord csvRecord : csvParser) {
    				
    				for (int i = 0; i < csvRecord.size(); i++) {
    					
    					String value = csvRecord.get(columeindex);
    					double converttodouble = Double.parseDouble(value);
    					linkedList.add(i,converttodouble);
    }
		  }

		 double addallevalues = 0;
         for(int i= 0; i<linkedList.size(); i++) {
        	addallevalues += linkedList.get(i);
         		}
         columeindex++;
         System.out.println("Spalte " + columeindex +" median "+addallevalues/linkedList.size()); 	
         
    }catch (IOException e) {
    e.printStackTrace();}
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public boolean addAll(Collection<? extends E> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public E get(int index) {
	// TODO Auto-generated method stub
	return null;
}
}



