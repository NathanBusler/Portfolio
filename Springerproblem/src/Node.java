import java.util.ArrayList;

public class Node {

	private ArrayList<Node> nodes;
	private Field field;
	private Node parent;
	private int num;
	
	public Node(Field field, Node parent, int num) {
		this.nodes = new ArrayList<Node>();
		this.field = field;
		this.parent = parent;
		this.num = num;
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public Field getField() {
		return field;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public int getNum() {
		return num;
	}
	
	
	
}
