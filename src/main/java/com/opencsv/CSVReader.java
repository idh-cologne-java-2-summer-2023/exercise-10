package com.opencsv;


import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {
	

	
	public static void main(String[] args) {
		int total;
		
		
		
		try {
			Reader csvData = new FileReader("src/main/resources/wine.csv");
			Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(csvData);
			//DEFAULT: RFC4180, via Komma getrennt.
			
			for (CSVRecord record : records) {
				
				//Länge: 2000; recordNumber.    				
/*1*/			String col1 = record.get(0);                                 //Spalte aufrufen.
				Double double1 = Double.valueOf(col1);                       //String zu Double.
				
			    ArrayList<Double> list1 = new ArrayList<Double>();
			    list1.add(double1);    
			    
			    double result1;
			    double sum = 0;
			    for (double a: list1) {
			    	sum = sum += a;
			        result1 = sum /2000;
			    	System.out.println(result1);
			    	
			    	}
		
//------------------------------------------------------------------------------------------------------------//		
				
				
			   
/*2*/			String col2 = record.get(1);
				Double double2 = Double.valueOf(col2);
				
				ArrayList<Double> list2 = new ArrayList<Double>();
				list2.add(double2);
				double result2;
				for (Double b: list2) {
					sum = sum += b;
			        result2 = sum /2000;
			    	System.out.println(result2);
				}
				
//------------------------------------------------------------------------------------------------------------//
				
				
/*3*/			String col3 = record.get(2);
				Double double3 = Double.valueOf(col3);
				
				ArrayList<Double> list3 = new ArrayList<Double>();
			    list3.add(double3);
			    double result3;
			    for (Double c: list3) {
			    	sum = sum += c;
			        result3 = sum /2000;
			    	System.out.println(result3);
			    }
			    
//------------------------------------------------------------------------------------------------------------//			    
			    

/*4*/			String col4= record.get(3);
				Double double4 = Double.valueOf(col4);
				
				ArrayList<Double> list4 = new ArrayList<Double>();
			    list4.add(double4);
			    double result4;
			    for (Double d: list4) {
			    	sum = sum += d;
			        result4 = sum /2000;
			    	System.out.println(result4);
			    	
			    }
			
//------------------------------------------------------------------------------------------------------------//			    
			    
				
/*5*/			String col5= record.get(4);
				Double double5 = Double.valueOf(col5);
				
				ArrayList<Double> list5 = new ArrayList<Double>();
			    list5.add(double5);
			    double result5;
			    for (Double e: list5) {
			    	sum = sum += e;
			        result5 = sum /2000;
			    	System.out.println(result5);
			    }
				
//------------------------------------------------------------------------------------------------------------//
			    
				
/*6*/			String col6= record.get(5);
				Double double6 = Double.valueOf(col6);
				
				ArrayList<Double> list6 = new ArrayList<Double>();
			    list6.add(double6);
			    double result6;
			    for (Double f: list6) {
			    	sum = sum += f;
			        result6 = sum /2000;
			    	System.out.println(result6);
			    }
				
//------------------------------------------------------------------------------------------------------------//				
				
				
/*7*/			String col7= record.get(6);
				Double double7 = Double.valueOf(col7);
				
				ArrayList<Double> list7 = new ArrayList<Double>();
			    list7.add(double7);
			    double result7;
			    for (Double g: list7) {
			    	sum = sum += g;
			        result7 = sum /2000;
			    	System.out.println(result7);
			    }
			    
//------------------------------------------------------------------------------------------------------------//			    
			    			
			    
/*8*/		    String col8= record.get(7);
				Double double8 = Double.valueOf(col8);
				
				ArrayList<Double> list8 = new ArrayList<Double>();
			    list8.add(double8);
			    double result8;
			    for (Double h: list8) {
			    	sum = sum += h;
			        result8 = sum /2000;
			    	System.out.println(result8);
			    }
			    
//------------------------------------------------------------------------------------------------------------//			    
			    
				
/*9*/	        String col9= record.get(8);
			    Double double9 = Double.valueOf(col9);
			    
			    ArrayList<Double> list9 = new ArrayList<Double>();
			    list9.add(double9);
			    double result9;
			    for (Double i: list9) {
			    	sum = sum += i;
			        result9 = sum /2000;
			    	System.out.println(result9);
			    }
			    
//------------------------------------------------------------------------------------------------------------//			    
		
			    
/*10*/	        String col10= record.get(9);
				Double double10 = Double.valueOf(col10);
				
				ArrayList<Double> list10 = new ArrayList<Double>();
			    list10.add(double10);
			    double result10;
			    for (Double j: list10) {
			    	sum = sum += j;
			        result10 = sum /2000;
			    	System.out.println(result10);
			    }
			    
//------------------------------------------------------------------------------------------------------------//			    
						
				
/*11*/          String col11= record.get(10);
				Double double11 = Double.valueOf(col11);
				
				ArrayList<Double> list11 = new ArrayList<Double>();
			    list11.add(double11);
			    double result11;
			    for (Double k: list11) {
			    	sum = sum += k;
			        result11 = sum /2000;
			    	System.out.println(result11);
			    }
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	
	}
	

}
