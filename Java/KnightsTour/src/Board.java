
/**
 * @author Nathan Busler
 *	Schachbrett
 */
public class Board {

	private Field[][] board;
	
	/** public Board(int size)
	 * @param size
	 * Erzeugt eine Instanz der Klasse Board mit size Spalten und size Zeilen.
	 */
	public Board(int size) {
		
		this.board = new Field[size][size];
		for (int i = size - 1; i > -1; i--) {
			for (int j = 0; j < size; j++) {
				board[j][i] = new Field(j,i);
			}
		}
	}
	
	/** public Field[][] getBoard()
	 * @return Field[][]
	 * Gibt das Field[][] des Boardes zurück.
	 */
	public Field[][] getBoard() {
		return board;
	}
	
	/** public String toString()
	 * Gibt die Felder des Boardes als String zurück.
	 */
	@Override
	public String toString() {
		
		StringBuilder bts = new StringBuilder();
		for (int i = board.length - 1; i > -1; i--) {
			for (int j = 0; j < board.length; j++) {
				bts.append(board[j][i].toString() + " ");
			}
			bts.append("\n");
		}
		return bts.toString();
	}
	
}
