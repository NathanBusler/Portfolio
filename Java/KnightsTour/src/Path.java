import java.util.ArrayList;

/**
 * @author Nathan Busler
 *	Weg des Springers.
 */
public class Path{

	private ArrayList<Field> path;
	private String type;
	
	/** public Path()
	 * erzeugt einen leeren Path.
	 */
	public Path() {
		this.path = new ArrayList<Field>();
		this.type = "";
	}
	
	/** public Path(Path visited, Field newField)
	 * @param visited
	 * @param newField
	 * erzeugt einen Path der gleich dem eingegebenen Path ist,
	 * und fügt diesem das eingegebene Field an.
	 */
	public Path(Path visited, Field newField) {
		this.path = new ArrayList<Field>();
		for (int nP = 0; nP < visited.length(); nP++) {
			path.add(visited.get(nP));
		}
		path.add(newField);
		this.type = "";
	}
	
	/** public Field get(int index)
	 * @param index
	 * @return Field
	 * Gibt das Field mit Index "index" zurück.
	 */
	public Field get(int index) {
		return path.get(index);
	}
	
	/** public void setType (String type)
	 * @param type
	 * Setzt den eingegebenen String als type des Paths.
	 */
	public void setType (String type) {
		this.type = type;
	}
	
	/** public void add(Field field)
	 * @param field
	 * Fügt dem Path das eingegebene Feld hinzu.
	 */
	public void add(Field field) {
		path.add(field);
	}
	
	/** public boolean contains(Field field)
	 * @param field
	 * @return boolean
	 * Gibt true zurück falls das Feld im Path enthalten ist, ansonsten false.
	 */
	public boolean contains(Field field) {
		if (path.contains(field)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/** public int length()
	 * @return int
	 * Gibt die Länge des Paths zurück.
	 */
	public int length() {
		return path.size();
	}
	
	/** public String toString()
	 * @return String
	 * Gibt den Pfad als String zurück.
	 */
	@Override
	public String toString() {
		
		StringBuilder pts = new StringBuilder();
		for (int p = 0; p < path.size(); p++) {
			pts.append(path.get(p).toString());
			pts.append(" ");
		}
		pts.append(type);
		return pts.toString();
		
	}


	
}
