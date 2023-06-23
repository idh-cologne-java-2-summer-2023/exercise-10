package idh.java;

import java.io.IOException;
import java.util.ArrayList;

public class CSVAverage {
	
	public static float averageMather(int column) {
		try {
			float allAddedUp = 0;
			int counter = 0;
			CSVReader csvreader = new CSVReader("src/main/resources/wine.csv");
			ArrayList<Float> columnContent = csvreader.readColumn(column);
			for(float content: columnContent) {
				allAddedUp += content;
				counter++;
			}
			return allAddedUp / counter;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(averageMather(8));
		

	}

}
