
/**
 * @author Nathan Busler
 *
 */
public class BadKeyException extends Exception {

	/** public BadKeyException()
	 * Erzeugt eine BadKeyException.
	 */
	public BadKeyException() {
		super("Der Schlüssel muss eine dieser Zahlen sein.\n3 5 7 9 11 15 17 19 21 23 25");
	}
	
}
