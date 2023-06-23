package idh.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public void printStats(File f) throws IOException {
		int countwords = 0;
		int counttypes = 0;
		int countlessthan5letters = 0;
		int countblood = 0;
		String mostcommonword = "";
		Document d = Document.readFromFile(new File("src/main/resources/dracula.txt"));
		Iterator<String> it = d.iterator();
		List<String> list = new ArrayList<String>();

		while (it.hasNext()) {
			list.add(it.next());
		}

//		for (String s : list) {
//			System.out.println(s);
//		}
		
		//Wörter
		Stream<String> stream = list.stream();
		countwords = (int) stream.count();
//		System.out.println("Wörter: " +  stream.count());
		
		//Blood
		Stream<String> streamblood = list.stream();
		 streamblood = streamblood.filter(s -> s.equals("blood"));
		 countblood = (int) streamblood.count();
//		System.out.println("Häufigkeit des Worts 'blood': " + streamblood.count());
		
//		Types
		Set<String> typeSet = new HashSet<String>();
		Stream<String> streamtypes0 = list.stream();
		Stream<String> streamtypes2 = streamtypes0.filter(s -> typeSet.add(s));;
		streamtypes2.collect(Collectors.toSet());
		counttypes = typeSet.size();
//		System.out.println("Verschiedene Types: " + typeSet.size());
		
		
		//Chars
		Stream<String> charstream = list.stream();
		Stream<String> charstream2 = charstream.filter(s -> s.length() < 5);
		List<String> charlist = charstream2.toList();
//		System.out.println("Anzahl der Wörter mit weniger als 5 Zeichen: " +  charlist.size());
		countlessthan5letters = charlist.size();
		
		//Häufigstes Wort
		
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(Function.identity(), word -> 1, Math::addExact));
//		System.out.println(map.values());
		Stream<Integer> values = map.values().stream().sorted();
		List<Integer> valueslist = values.toList();
		int highest = valueslist.get(valueslist.size()-1);
		
		for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
	        if (entry.getValue().equals(highest)) {
	        	
//	            System.out.println("Häufgstes Wort: " + entry.getKey());
	            mostcommonword = entry.getKey();
	        }

	    }
			try (
					OutputStreamWriter file = new OutputStreamWriter(new FileOutputStream("src/main/resources/draculawords.csv"), StandardCharsets.UTF_8);
					BufferedWriter out = new BufferedWriter(file);
			        CSVPrinter printer = new CSVPrinter( out , CSVFormat.DEFAULT ) ;
			)
			{
				printer.printRecord("Anzahl der Wörter", "Anzahl Types", "Anzahl Wörter kürzer als 5 Zeichen", "Häufigkeit blood", "häufigstes Wort", "häufigstes großgeschriebene Wort");
				printer.printRecord(countwords, counttypes, countlessthan5letters, countblood, mostcommonword, "nicht gelöst");
			} catch ( IOException e )
			{
				System.out.println("hallo");
			    e.printStackTrace();
			}
			
		}

	public static final void main(String[] args) throws IOException {
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
