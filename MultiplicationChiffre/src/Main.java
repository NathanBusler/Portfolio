import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Scanner;

/**
 * @author Nathan Busler
 *
 */
public class Main {
	
	/** private static void writeToFile(String string, File file) throws IOException
	 * @param string
	 * @param file
	 * @throws IOException
	 * 
	 * Schreib den eingegebenen String in das eingegebene File.
	 * Wirft eine IOException sobald ein Fehler auftritt.
	 */
	private static void writeToFile(String string, File file) throws IOException {
	    try (
	        BufferedReader reader = new BufferedReader(new StringReader(string));
	        PrintWriter writer = new PrintWriter(new FileWriter(file));
	    ) {
	        reader.lines().forEach(line -> writer.println(line));
	    }
	}
	
	/** public static void start() throws IOException
	 * @throws IOException
	 * Erfragt ob der User Chiffrieren oder Dechiffrieren möchte.
	 * Erfragt welcher Text bearbeitet werden soll.
	 * Erfragt welcher Schlüssel verwendet werden soll.
	 * Erfragt unter welchem Namen die Ergebnisse gespeichert werden sollen.
	 * Führt die Chiffrierung/Dechiffrierung aus und speichert die Ergebnisse.
	 */
	public static void start() throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		char mode = ' ';
		while (mode != 'C' && mode != 'D') {
			System.out.println("Wenn Sie Chiffrieren möchten, geben Sie 'C' ein.\nWenn Sie Dechiffrieren möchten, geben Sie 'D' ein.");
			mode = in.next().charAt(0);
		}
		
		if (mode == 'C') {
			boolean fN = false;
			String fileName = " ";
			Text chifText = new Text("Gedicht.txt");
			while (fN == false) {
				System.out.println("Bitte geben Sie den Dateinamen des Textes ein, den Sie chiffrieren möchten (mit Dateiendung).");
				try {
					fileName = in.next();
					chifText = new Text(fileName);
					chifText.transformiere();
					fN = true;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			int key = 0;
			System.out.println("Bitte geben Sie den Schlüssel ein.\nDer Schlüssel muss eine dieser Zahlen sein\n3 5 7 9 11 15 17 19 21 23 25");
			while(key < 3 || key > 25 || key%2 == 0 || key == 13) {
				try {
					key = Integer.parseInt(in.next());
					if (key < 3 || key > 25 || key%2 == 0 || key == 13 ) {
						throw new BadKeyException();
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Bitte geben Sie eine dieser Zahlen ein\n3 5 7 9 11 15 17 19 21 23 25");
					key = 0;
				}
				catch (BadKeyException e) {
					System.out.println(e.getMessage());
				}
			}
			
			
			System.out.println("Geben Sie den gewünschten Dateinamen für den chiffrierten Text ohne Dateiendung ein.");
			try {
				StringBuilder chifName = new StringBuilder();
				chifName.append(in.next());
				chifName.append(".txt");
				File outFile = new File(chifName.toString());
				
				System.out.println(fileName + " wird mit dem Schlüssel " + key + " chiffriert.\n");
				
				Table encTable = new Table(key);
				Encryptor enc = new Encryptor(chifText, encTable);
				
				System.out.println(enc.toString());
				
				File tfile = new File("Tabelle.txt");
				writeToFile(encTable.toString(), tfile);
				
				System.out.println("\nÜbersetzungstablle\n" + encTable.toString() + "\n");
				
				
				enc.encrypt();
				
				System.out.println(enc.toString());
				writeToFile(enc.toString(), outFile);
			}
			catch (Exception e ) {
				e.printStackTrace();
			}
			
		}
		
		else if (mode == 'D'){
			
			boolean fN = false;
			String fileName = " ";
			Text dechText = new Text("Gedicht.txt");
			while (fN == false) {
				System.out.println("Bitte geben Sie den Dateinamen des Textes ein, den Sie dechiffrieren möchten (mit Dateiendung).");
				try {
					fileName = in.next();
					dechText = new Text(fileName);
					dechText.transformiere();
					fN = true;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			int key = 0;
			System.out.println("Bitte geben Sie den Schlüssel ein.\nDer Schlüssel muss eine dieser Zahlen sein\n3 5 7 9 11 15 17 19 21 23 25\nFalls Sie den Schlüssel nicht kennen, geben Sie etwas beliebiges ein.");
				try {
					key = Integer.parseInt(in.next());
					if (key < 3 || key > 25 || key%2 == 0 || key == 13 ) {
						key = 0;
					}
				}
				catch (NumberFormatException e) {
					key = 0;
				}
			
				System.out.println("Geben Sie den gewünschten Dateinamen für den dechiffrierten Text ohne Dateiendung ein.");
				try {
					StringBuilder dechName = new StringBuilder();
					dechName.append(in.next());
					dechName.append(".txt");
					File outFile = new File(dechName.toString());
					
					System.out.println(fileName + " wird dechiffriert.\n");
					Decryptor dec = new Decryptor(dechText);
					
					System.out.println(dec.toString());
					
					if (key == 0) {
						key = dec.decrypt();
					}
					else {
						dec.decrypt(key);
					}
					
					Table decTable = new Table(key);
					File tfile = new File("Tabelle.txt");
					writeToFile(decTable.flipToString(), tfile);
					
					System.out.println("\nÜbersetzungstablle\n" + decTable.flipToString() + "\n");
					
					System.out.println(dec.toString());
					writeToFile(dec.toString(), outFile);
					
				}
				catch (Exception e ) {
					e.printStackTrace();
				}
				
		}

		in.close();
		
	}
	
	public static void main(String[] args) {

		try {
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
