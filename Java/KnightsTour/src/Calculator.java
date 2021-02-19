import java.util.ArrayList;

/**
 * @author Nathan Busler
 *
 */
public class Calculator {

	private ArrayList<Path> paths;
	private Board board;
	private Field startfeld;
	private Springer springer;
	private static int winC;
	
	/** public Calculator(Board board, Field startfeld)
	 * @param board
	 * @param startfeld
	 * Erzeugt einen Calculator mit dem einegebenen Board und dem eingegebenen Startfeld.
	 */
	public Calculator(Board board, Field startfeld) {
		this.paths = new ArrayList<Path>();
		this.board = board;
		this.startfeld = startfeld;
		this.springer = new Springer(startfeld);
		
		if (board.getBoard().length == 3) {
			winC = 8;
		}
		else if (board.getBoard().length > 3) {
			winC = board.getBoard().length * board.getBoard().length;
		}
	}
	
	/** public Board getBoard()
	 * @return Board
	 * Gibt das Board zurück.
	 */
	public Board getBoard() {
		return board;
	}
	
	/** public Field getStartFeld()
	 * @return Field
	 * Gibt das Startfeld zurück.
	 */
	public Field getStartFeld() {
		return startfeld;
	}
	
	/** public ArrayList<Field> moves(Path visited)
	 * @param visited
	 * @return ArrayList<Field>
	 * erzeugt eine ArrayList aller möglichen nächsten Züge,
	 * in Abhängigkeit der bereites besuchten Felder (visited)
	 * und der Boardgröße.
	 * Diese Liste wird zurückgegeben.
	 */
	public ArrayList<Field> moves(Path visited) {
		ArrayList<Field> possibleMoves = new ArrayList<Field>();
		if (springer.getField().getS() + 2 < board.getBoard().length) {
			if (springer.getField().getZ() + 1 < board.getBoard().length) {
				possibleMoves.add(board.getBoard()[springer.getField().getS()+2][springer.getField().getZ()+1]);
				//System.out.println(possibleMoves.get(possibleMoves.size()-1).toString());
			}
			if (springer.getField().getZ() -1 >= 0) {
				possibleMoves.add(board.getBoard()[springer.getField().getS()+2][springer.getField().getZ()-1]);
				//System.out.println(possibleMoves.get(possibleMoves.size()-1).toString());
			}
		}
		if (springer.getField().getS() + 1 < board.getBoard().length) {
			if (springer.getField().getZ() + 2 < board.getBoard().length) {
				possibleMoves.add(board.getBoard()[springer.getField().getS()+1][springer.getField().getZ()+2]);
				//System.out.println(possibleMoves.get(possibleMoves.size()-1).toString());
			}
			if (springer.getField().getZ() -2 >= 0) {
				possibleMoves.add(board.getBoard()[springer.getField().getS()+1][springer.getField().getZ()-2]);
				//System.out.println(possibleMoves.get(possibleMoves.size()-1).toString());
			}
		}
		if (springer.getField().getS() -1 >= 0) {
			if (springer.getField().getZ() + 2 < board.getBoard().length) {
				possibleMoves.add(board.getBoard()[springer.getField().getS()-1][springer.getField().getZ()+2]);
				//System.out.println(possibleMoves.get(possibleMoves.size()-1).toString());
			}
			if (springer.getField().getZ() -2 >= 0) {
				possibleMoves.add(board.getBoard()[springer.getField().getS()-1][springer.getField().getZ()-2]);
				//System.out.println(possibleMoves.get(possibleMoves.size()-1).toString());
			}
		}
		if (springer.getField().getS() -2 >= 0) {
			if (springer.getField().getZ() + 1 < board.getBoard().length) {
				possibleMoves.add(board.getBoard()[springer.getField().getS()-2][springer.getField().getZ()+1]);
				//System.out.println(possibleMoves.get(possibleMoves.size()-1).toString());
			}
			if (springer.getField().getZ() -1 >= 0) {
				possibleMoves.add(board.getBoard()[springer.getField().getS()-2][springer.getField().getZ()-1]);
				//System.out.println(possibleMoves.get(possibleMoves.size()-1).toString());
			}
		}
		
		for (int c = 0; c < visited.length(); c++) {
			if (possibleMoves.contains(visited.get(c))) {
				possibleMoves.remove(visited.get(c));
			}
		}
		
		return possibleMoves;
	}
	
	/** public boolean classic(Path visited, int move)
	 * @param visited
	 * @param move
	 * @return boolean
	 * Kalkuliert die klassische Varaiante des Springerproblems rekursiv.
	 */
	public boolean classic(Path visited, int move) {
		if (move == winC) {
			if (moves(new Path()).contains(startfeld)) {
				visited.setType("Geschlossen");
			}
			else {
				visited.setType("Offen");
			}
			paths.add(visited);
			return true;
		}
		else {
			ArrayList<Field> pM = moves(visited);
			if (pM.size() == 0) {
				return false;
			}
			else {
				move++;
				for (int pm = 0; pm < pM.size(); pm++) {
					springer.move(pM.get(pm));
					classic(new Path(visited, pM.get(pm)), move);
				}
			}
		}
		return false;
	}
	
	/** public boolean simple(Path visited, int move)
	 * @param visited
	 * @param move
	 * @return boolean
	 * Kalkuliert die simple Varaiante des Springerproblems rekursiv.
	 */
	public boolean simple(Path visited, int move) {
		if (visited.contains(board.getBoard()[0][0]) && visited.contains(board.getBoard()[0][board.getBoard().length -1]) && visited.contains(board.getBoard()[board.getBoard().length - 1][0]) && visited.contains(board.getBoard()[board.getBoard().length -1][board.getBoard().length - 1])) {
			if (moves(new Path()).contains(startfeld)) {
				visited.setType("Geschlossen");
			}
			else {
				visited.setType("Offen");
			}
			paths.add(visited);
			return true;
		}
		else {
			ArrayList<Field> pM = moves(visited);
			if (pM.size() == 0) {
				return false;
			}
			else {
				move++;
				for (int pm = 0; pm < pM.size(); pm++) {
					springer.move(pM.get(pm));
					simple(new Path(visited, pM.get(pm)), move);
				}
			}
		}
		return false;
	}
	
	/** public ArrayList<Path> getPaths()
	 * @return ArrayList<Path>
	 * Gibt die paths zurück.
	 */
	public ArrayList<Path> getPaths() {
		return paths;
	}
	
	/** public int pathsSize()
	 * @return int
	 * Gibt die Anzahl an Paths zurück,
	 * also die size von paths zurück.
	 */
	public int pathsSize() {
		return paths.size();
	}
	
	/** public String pathsToString(int anz)
	 * @param anz
	 * @return String
	 * Gibt die eingegebene Anzahl an Paths als String zurück.
	 */
	public String pathsToString(int anz) {
		StringBuilder psb = new StringBuilder();
		
		if (anz > paths.size()) {
			psb.append(paths.size() + " Lösungen.\n");
			for (int pts = 0; pts < paths.size(); pts++) {
				psb.append(paths.get(pts).toString());
				psb.append("\n");
			}
			return psb.toString();
		}
		else {
			psb.append(paths.size() + " Lösungen.\n");
			for (int pts = 0; pts < anz; pts++) {
				psb.append(paths.get(pts).toString());
				psb.append("\n");
			}
			return psb.toString();
		}
	}
	
}
