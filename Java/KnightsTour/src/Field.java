
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
	 * Gibt die Spaltennummer des Feldes zur�ck.
	 */
	public int getS() {
		return s;
	}
	
	/** public int getZ()
	 * @return z
	 * Gibt die Zeilennummer des Feldes zur�ck.
	 */
	public int getZ() {
		return z;
	}
	
	 /** public String toString()
	 * Gibt die f�r Schach �bliche notation des Feldes als String zur�ck.
	 */
	@Override
	public String toString() {
		
		 StringBuilder fts = new StringBuilder();
		 fts.append((char) (s + 97));
		 fts.append(z+1);
		 return fts.toString();
		 
	}

}
