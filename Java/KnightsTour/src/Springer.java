
/**
 * @author Nathan Busler
 * Springer
 */
public class Springer {

	private Field field;
	
	/** public Springer(Field field)
	 * @param field
	 * Erzeugt eine Instanz der Klasse Springer, welche das eingegebene Feld speichert.
	 */
	public Springer(Field field) {
		this.field = field;
	}
	
	/** public Field getField()
	 * @return Field
	 * Gibt das Feld zurück, auf dem sich der Springer derzeit befindet.
	 */
	public Field getField() {
		return field;
	}
	
	/** public void move(Field field)
	 * @param field
	 * Setzt den Springer auf das angegebene Feld.
	 */
	public void move(Field field) {
		this.field = field;
	}
	
}
