
/**
 * @author Nathan Busler
 *
 */
public class Encryptor {

	private Text text;
	private Table table;
	
	/** public Encryptor(Text text, Table table)
	 * @param text
	 * @param table
	 * Erzeugt ein Objekt der Klasse Encryptor.
	 */
	public Encryptor(Text text, Table table) {
		this.text = text;
		this.table = table;
	}
	
	public Text getText() {
		return text;
	}
	
	/** public void encrypt()
	 * Verschlüsselt den Text.
	 */
	public void encrypt() {
		
		for (int enc = 0; enc < text.size(); enc++) {
			if (text.get(enc) > 96 && text.get(enc) < 123) {
				Character tmp = table.getTable().get(text.get(enc));
				text.set(enc, tmp);
			}
		}
		
	}
	
	/** public String toString()
	 * Gibt Text als String zurück.
	 */
	@Override
	public String toString() {
		return text.toString();
	}
	
}
