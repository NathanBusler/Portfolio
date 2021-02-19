
/** public class Field
 * @author Nathan Busler
 * Feld des Schachfeldes 
 */
public class Field {
	
	private int s;
	private int z;
	
	/** public Field(int s, int z)
	 * @param s
	 * @param z
	 * Erzeugt eine Instanz der Klasse Field mit Spaltennummer s und Zeilennummer z.
	 */
	public Field(int s, int z) {
		this.s = s;
		this.z = z;
	}
	
	/** public int getS()
	 * @return s
	 * Gibt die Spaltennummer des Feldes zurück.
	 */
	public int getS() {
		return s;
	}
	
	/** public int getZ()
	 * @return z
	 * Gibt die Zeilennummer des Feldes zurück.
	 */
	public int getZ() {
		return z;
	}
	
	 /** public String toString()
	 * Gibt die für Schach übliche notation des Feldes als String zurück.
	 */
	@Override
	public String toString() {
		
		 StringBuilder fts = new StringBuilder();
		 fts.append((char) (s + 97));
		 fts.append(z+1);
		 return fts.toString();
		 
	}

}
