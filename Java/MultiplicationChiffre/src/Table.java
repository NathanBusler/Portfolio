import java.util.HashMap;
import java.util.Map;

/**
 * @author Nathan Busler
 *
 */
public class Table {

	private HashMap<Character,Character> table;
	
	/** public Table(int key)
	 * @param key
	 * Erstellt eine HashMap die die Buchstaben im Alphabet auf ihre jeweiligen
	 * per multiplicatin chiffre ermittelten Buchstaben mapt. 
	 */
	public Table(int key) {
		
		
		this.table = new HashMap<Character,Character>();
		
		Map<Character,Integer> alphabet = new HashMap<Character,Integer>();
		
			for (int i = 0; i < 25; i++) {
				alphabet.put((char) (97 + i), i+1);
			}
			alphabet.put('z', 0);
		
			for (int i = 0; i < 25; i++) {
			
				int val = alphabet.get((char) (97 + i));
				int vk  = val*key;
				Integer vm  = vk%26;
			
				//System.out.println(vm);
			
				Character chary = ' ';
				for (Map.Entry<Character, Integer> entry: alphabet.entrySet()) {
					if (vm.equals(entry.getValue())){
						chary = entry.getKey();
					}
				}
			
				table.put((char) (97 + i), chary);
			
			}
		
			table.put('z', 'z');
			
	}
	
	/** public HashMap<Character,Character> getTable()
	 * @return table
	 * Gibt die gespeicherte Übersetzungstabelle zurück.
	 */
	public HashMap<Character,Character> getTable(){
		return table;
	}
	
	/** public String toString()
	 * Gibt die Übersetzungstabelle als String zurück.
	 */
	@Override
	public String toString() {
		
		StringBuilder tbl = new StringBuilder();
		
		table.forEach((k, v) -> {
			tbl.append(k);
			tbl.append(' ');
		});
		tbl.append("\n");
		table.forEach((k, v) -> {
			tbl.append(v);
			tbl.append(' ');
		});
		tbl.append("\n");
		
	
		return tbl.toString();
	}
	
	/** public String flipToString()
	 * @return String
	 * Gibt die Tabelle als String mit vertauschten Keys und Values zurück.
	 */
	public String flipToString() {
		
		StringBuilder tbl = new StringBuilder();
		
		table.forEach((k, v) -> {
			tbl.append(v);
			tbl.append(' ');
		});
		tbl.append("\n");
		table.forEach((k, v) -> {
			tbl.append(k);
			tbl.append(' ');
		});
		tbl.append("\n");
		
		return tbl.toString();
	}

}
