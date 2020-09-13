
public class MainTemperaturCSV {

	public static void main(String[] args) {
		/*
		 * Die Datei TemperaturenJJJJ.csv muss im Projektverzeichnis liegen (nicht im
		 * src oder im bin)
		 */

		// Das Objekt, welches die Daten aus der CSV-Datei ausliest
		TemperatureDataRetriever tdr = new TemperatureDataRetriever("Temperaturen2019.csv");
		
		int sum=0, average=0;


		for(int i =0; i < tdr.ANZAHL_DATENSAETZE; i++) {
			if(tdr.getTemperatureInLine(i)>=45) {
				int temp = tdr.getTemperatureInLine(i);
				System.out.println("Falsche Stelle in Zeile"+(i+1));
				System.out.println(temp);
				i=i+1;
			}
			if(tdr.getTemperatureInLine(i)<=-15) {
				int temp = tdr.getTemperatureInLine(i);
				System.out.println("Falsche Stelle in Zeile"+(i+1));
				System.out.println(temp);
				i=i+1;
			}
			sum = sum + tdr.getTemperatureInLine(i);
		}
		average = sum / tdr.ANZAHL_DATENSAETZE;
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Durchschnitt: "  + average);
	}

}
