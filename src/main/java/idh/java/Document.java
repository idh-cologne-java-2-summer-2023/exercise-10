package idh.java;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;


import org.apache.commons.io.FileUtils;

public class Document implements Iterable<String> {
	String documentText;

	public static Document readFromFile(File f) throws IOException {
		
		Document doc = new Document();
		doc.documentText = FileUtils.readFileToString(f, "UTF-8");
		
		return doc;
	}
	
	public String getDocumentText() {
		return documentText;
	}

	public void setDocumentText(String documentText) {
		this.documentText = documentText;
	}
	
	
	
	
	public void printStats(File f) {	 
	}
	

	public void printStatsofword(File f, String word) {	 
	}
	
	public static final void main(String[] args) throws IOException {
		
		String csvFilePath = "src/main/resources/wine.csv";
		
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            int rowCount = 0;
            double[] columnSums = null;

            while ((line = reader.readLine()) != null) {
                rowCount++;

                String[] values = line.split(",");
                if (columnSums == null) {
                    columnSums = new double[values.length];
                }

                for (int i = 0; i < values.length; i++) {
                    double value = Double.parseDouble(values[i]);
                    columnSums[i] += value;
                }
            }
            
            System.out.println("Column Averages:");

            for (double sum : columnSums) {
                double average = sum / rowCount;
                System.out.println(average);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
   
        
		
		Document d = Document.readFromFile(new File("src/main/resources/dracula.txt"));
		d.printStats(new File("target/stats.csv"));
	}

	public Iterator<String> iterator() {
		return new Iterator<String>() {

			StringTokenizer tokenizer = new StringTokenizer(documentText);
			
			
			public boolean hasNext() {
				return tokenizer.hasMoreTokens();
			}

			public String next() {
				return tokenizer.nextToken();
			}
			
		};
	}
	
	
}
