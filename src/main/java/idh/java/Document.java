package idh.java;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
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
	
	public static void printStats(String f, String cat, String res) throws IOException {
		try (FileWriter wri = new FileWriter(f, true);
	         CSVPrinter prin = new CSVPrinter(wri,CSVFormat.EXCEL)) {
				prin.printRecord(cat, res);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("src/main/resources/dracula.txt"));
		for(String token : d) {
			//System.out.println(token);
		}
		numberOfWords(d);
		numberOfTypes(d);
		numberOfBelow5(d);
		numberOfBlood(d);
		//printStats("src/main/resources/stats.csv", "True", "False");
	}
	
	public static void numberOfWords(Document doc) throws IOException {
		int i = 0;
		for(String token : doc) {
			i++;
		}
		printStats("src/main/resources/stats.csv", "Anzahl der Worte", String.valueOf(i));
	}

	public static void numberOfTypes(Document doc) throws IOException {
		int tokens = 0;
		Set<String> types = new HashSet<String>();
		for (String token : doc) {
			types.add(token);
			tokens++;
		}
		printStats("src/main/resources/stats.csv", "Anzahl der Types", String.valueOf(types.size()));		
	}
	
	public static void numberOfBelow5(Document doc) throws IOException {
		int i = 0;
		for(String token : doc) {
			if(token.length() < 5) {
				i++;
			}
		}
		printStats("src/main/resources/stats.csv", "Anzahl der Wörter unter 5 Zeichen", String.valueOf(i));
	}
	
	public static void numberOfBlood(Document doc) throws IOException {
		int i = 0;
		for(String token : doc) {
			if(token.equals("blood") ||  token.equals("Blood")) {
				i++;
			}
		}
		printStats("src/main/resources/stats.csv", "Anzahl des Wortes 'blood'", String.valueOf(i));

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
