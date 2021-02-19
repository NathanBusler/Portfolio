
import java.util.Map.Entry;

/**
 * @author Nathan Busler
 *
 */
public class Decryptor {

	private Text text;
	
	/** public Decryptor(Text text)
	 * @param text
	 * Erzeugt eine Instanz der Klasse Decryptor mit dem eingegebenen Text als Text.
	 */
	public Decryptor(Text text) {
		this.text = text;
	}
	
	/** public void decrypt(int key)
	 * @param key
	 * Entschlüsselt den gespeicherten Text mithilfe des eingegebenen Keys.
	 */
	public void decrypt(int key) {
		
		Table table = new Table(key);
		for (int dec = 0; dec < text.size(); dec++) {
			if (text.get(dec) > 96 && text.get(dec) < 123) {
				Character tmp = 0;
				
				for (Entry<Character, Character> entry : table.getTable().entrySet()) {
					if (entry.getValue().equals(text.get(dec))) {
						tmp = entry.getKey();
					}
				}
				
				text.set(dec, tmp);
			}
		}
	}
	
	/** public int decrypt()
	 * @return int
	 * Ermittelt per Kryptoanalyse, welcher Schlüssel zur Verschlüsselung verwendet wurde.
	 * Der gespeicherte Text wird entschlüsselt und der Schlüssel zurückgegeben.
	 */
	public int decrypt() {
		char[] relevanz = "enisratdhulcgmobwfkzpvjyxq".toCharArray();
		int[] keys = {3,5,7,9,11,15,17,19,21,23,25};
		boolean solved = false;
		
		char[] hfg = text.hfgktChar();
		
		int i = 0;
		int solvedKey = 0;
		
		while (solved == false) {
			for (int s = 0; s < keys.length; s++) {
				int l = relevanz[i]-96;
				int m = l*keys[s];
				int o = m%26;
				//System.out.println(hfg[i] + " = " + (char) (o + 96));
				if ((char) (o + 96) == hfg[i]) {
					solvedKey = keys[s];
					solved = true;
				}
			}
			
			i++;
		}
		
		System.out.println("Der Schlüssel ist " + solvedKey + "\n");
		
		decrypt(solvedKey);
		
		return solvedKey;
		
	}
	
	/** @Override
	 * public String toString()
	 * @return String
	 * Gibt den gespeicherten Text als String zurück.
	 */
	@Override
	public String toString() {
		return text.toString();
	}
	
}
