
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Nathan Busler
 * Liest einen Text ein und formatiert ihn bei bedarf.
 */
public class Text {

	private ArrayList<Character> text;
	
	public Text(String dateiname) {

		try { 
	        	
	      TextScanner sc = new TextScanner(dateiname);
	      this.text = sc.scanText();

		} catch (Exception e) {
	        e.printStackTrace();
		}
		
	}
	
	/** public ArrayList<Character> transformiere()
	 * @return ArrayList<Character>
	 * Alle Buchstaben werden in kleinbuchstaben umgewandelt.
	 * "ä" wird zu "ae".
	 * "ö" wird zu "oe".
	 * "ü" wird zu "ue".
	 * "ß" wird zu "sz".
	 */
	public ArrayList<Character> transformiere() {
		
		for (int i = 0; i < text.size(); i++) {
			
			text.set(i, Character.toLowerCase(text.get(i)));
			
			if (text.get(i) == 'ä') {
				//System.out.println("inside ä");
				text.add(' ');
				for (int mv = text.size()-1; mv > i+1; mv--) {
					Character tmp = text.get(mv);
					text.set(mv, text.get(mv-1));
					text.set(mv-1, tmp);
				}
				text.set(i, 'a');
				text.set(i+1, 'e');
			}
			else if (text.get(i) == 'ö') {
				//System.out.println("inside ö");
				text.add(' ');
				for (int mv = text.size()-1; mv > i+1; mv--) {
					Character tmp = text.get(mv);
					text.set(mv, text.get(mv-1));
					text.set(mv-1, tmp);
				}
				text.set(i, 'o');
				text.set(i+1, 'e');
			}
			else if (text.get(i) == 'ü') {
				//System.out.println("inside ü");
				text.add(' ');
				for (int mv = text.size()-1; mv > i+1; mv--) {
					Character tmp = text.get(mv);
					text.set(mv, text.get(mv-1));
					text.set(mv-1, tmp);
				}
				text.set(i, 'u');
				text.set(i+1, 'e');
			}
			else if (text.get(i) == 'ß') {
				//System.out.println("inside ß");
				text.add(' ');
				for (int mv = text.size()-1; mv > i+1; mv--) {
					Character tmp = text.get(mv);
					text.set(mv, text.get(mv-1));
					text.set(mv-1, tmp);
				}
				text.set(i, 's');
				text.set(i+1, 'z');
			}
			
			//System.out.println(i + " " + text.get(i));
		}
		
        //System.out.print(text.size() + "\n");
		/*for (int pr = 0; pr < text.size(); pr++) {
			System.out.print(text.get(pr));
		}
		*/
		return text;
	}
	
	/** public char[] hfgktChar()
	 * @return char[]
	 * Gibt die Buchstaben des Alphabets als char[] zurück,
	 * so dass sie nach Häufigkeit im Text geordnet sind.
	 */
	public char[] hfgktChar() {

		
		double[] dbl = new double[26];
		for (int d = 1; d < 27; d++) {
			dbl[d-1] = 0.01*d;
			//System.out.println(dbl[d-1]);
		}
		
		for (int i = 0; i < text.size(); i++) {
			if (text.get(i) > 96 && text.get(i) < 123) {
					int pos = text.get(i) - 97;
					dbl[pos]++;	
				}	
		}
		
		Arrays.sort(dbl);
		
		for (int i = 0; i < dbl.length / 2; i++) {
	        double tmp = dbl[i];
	        dbl[i] = dbl[dbl.length - 1 - i];
	        dbl[dbl.length - 1 - i] = tmp;
	    }
		
		char[] hfgkt = new char[26];
		
		for (int i = 0; i < 26; i++) {
			//System.out.println(dbl[i]);
			int tmpint = ((Double) dbl[i]).intValue();
			//System.out.println("tmpint = " + tmpint);
			Double dblval = ((dbl[i] - tmpint) * 100 + 96);
			//System.out.println("dblval = " + dblval);
			int charval = (int) Math.round(dblval);
			//System.out.println("charval = " + charval);
			hfgkt[i] = (char) charval;
			//System.out.println(hfgkt[i]);
		}
		
		return hfgkt;
	}
	
	/** @Override
	 * public String toString()
	 * @return String
	 * Gibt den Text als String zurück.
	 */
	@Override
	public String toString() {
		StringBuilder tts = new StringBuilder();
		for (int i = 0; i < text.size(); i++) {
			tts.append(text.get(i));
		}
		
		return tts.toString();
	}

	public int size() {
		return text.size();
	}
	
	public Character get(int index) {
		return text.get(index);
	}

	public void set(int index, Character element) {
		text.set(index, element);
	}
	
	
}
