import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nathan Busler
 *
 */
public class TextScanner {

	private Scanner ts;

	/** 	public TextScanner(String datei)
	 * @param datei
	 * Erstellt einen TextScanner für die eingegebene Datei.
	 */
	public TextScanner(String datei) {
		try {
			this.ts = new Scanner(new File(datei));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** public ArrayList<Character> scanText()
	 * @return ArrayList<Character>
	 * Gibt die eingegebene Datei als ArrayList<Character> zurück.
	 */
	public ArrayList<Character> scanText() {
		
		StringBuilder st = new StringBuilder();
		while (ts.hasNextLine()) {
			st.append(ts.nextLine());
			st.append("\n");
		}
		char[] chararray = st.toString().toCharArray();
        ArrayList<Character> out = new ArrayList<Character>();
        for (int i = 0; i < chararray.length; i++) {
     	   out.add(chararray[i]);
        }
        ts.close();
        
        return out;
		
	}
	
}
