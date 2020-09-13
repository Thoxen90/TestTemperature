import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TemperatureDataRetriever {

	private static final String COMMA_DELIMITER = ";";
	public final int ANZAHL_DATENSAETZE=365, ANZAHL_SPALTEN=2; //so von uns vorgegeben
	private String filename = null;
	private String[][] records;

	public String[][] getRecords() {
		return records;
	}

	public TemperatureDataRetriever(String filename) {
		super();
		this.filename = filename;
		retrieve();
	}

	//Temperatur ist in der CSV-Datei eine ganze Zahl
	int getTemperatureInLine(int lineNumber) {
		return Integer.parseInt(records[lineNumber][1]);
	}

	void retrieve() {
		records = new String[ANZAHL_DATENSAETZE][ANZAHL_SPALTEN];		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line;
		    for (int i=0; i<ANZAHL_DATENSAETZE ;i++) {
		    	line = br.readLine();
		    	String[] values;
		    	if(line != null) {
		        values = line.split(COMMA_DELIMITER);
		        records[i] =values;
		    	}
		    	
		    }
		} 
		
	catch (FileNotFoundException e) {
			System.out.println("CSV-file does not exist.");
			e.printStackTrace();
		}
		
	catch (IOException e) {
			System.out.println("Record does not exist.");
			e.printStackTrace();
		}
		
	}

	String[][] getTemperatures() {
		retrieve();
		return records;
	}

	public void printData() {

		for (String[] stringList : records) {
			for (String s : stringList)
				System.out.print(s + "; ");
			System.out.println();
		}
	}
}
