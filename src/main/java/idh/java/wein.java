package idh.java;


public class wein extends Document {
	
	private static final String Document = "src/main/resources/dracula.txt";

	public static void main(String[] args) {
	        String zahl= Document;
	        double doc = Durschnitt(zahl);
	        System.out.println("Der Durschnitt ist:" + " " + doc);
	   
	}
	
	public static double DurschnittSpalte(int [] zahl) {
		int ziffer = 0;
		int menge = zahl.length;
		int zaehlen = 0;
		
		
		for (int i = 0; i < menge; i++) {
			int[] zahlen = zahl;
			
			if(zahl > 0) {
				ziffer = ziffer + zahlen;
				zaehlen++;
			}
			
			double doc = ziffer / zaehlen;
		}
		return zaehlen;
	}

	private static double Durschnitt(String zahl) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
