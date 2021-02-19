
public class PathTree {

	Node root;
	
	public PathTree() {
		root = null;
	}
	
	public void insert(Field field) {
		if (root == null) {
			root = new Node(field, null, 0);
		}
		else {
			insert(root, field);
		}
	}

	public void insert(Node  parent, Field field) {
		if (parent.getNodes().size() < 8) {
			parent.getNodes().add(new Node(field, parent, parent.getNum() + 1));		
		}
		else {
			System.out.println("This node cannot save more Fields.");
		}
	}
	
	public int getHight() {
		int[] hights = {0,0,0,0,0,0,0,0,};
		for (int i = 0; i < hights.length; i++) {
			if(root.getNodes().get(i) != null) {
				hights[i] = getHight(root.getNodes().get(i)) + 1;
			}
		}
		return Math.max(Math.max(Math.max(hights[0], hights[1]), Math.max(hights[2], hights[3])), Math.max(Math.max(hights[4], hights[5]), Math.max(hights[6], hights[7])));
	}
	
	private int getHight(Node parent) {
		int[] hights = {0,0,0,0,0,0,0,0,};
		for (int i = 0; i < 8; i++) {
			if(parent.getNodes().get(i) != null) {
				hights[i] = getHight(parent.getNodes().get(i)) + 1;
			}
		}
		return Math.max(Math.max(Math.max(hights[0], hights[1]), Math.max(hights[2], hights[3])), Math.max(Math.max(hights[4], hights[5]), Math.max(hights[6], hights[7])));
	}

	public int amountNodes() {
		if (root == null) {
			return 0;
		}
		else {
			return 1 + amountNodes(root.getNodes().get(0)) + amountNodes(root.getNodes().get(1)) + amountNodes(root.getNodes().get(2)) + amountNodes(root.getNodes().get(3)) + amountNodes(root.getNodes().get(4)) + amountNodes(root.getNodes().get(5)) + amountNodes(root.getNodes().get(6)) + amountNodes(root.getNodes().get(7));
		}
	}

	private int amountNodes(Node parent) {
		if (root == null) {
			return 0;
		}
		else {
			return 1 + amountNodes(parent.getNodes().get(0)) + amountNodes(parent.getNodes().get(1)) + amountNodes(parent.getNodes().get(2)) + amountNodes(parent.getNodes().get(3)) + amountNodes(parent.getNodes().get(4)) + amountNodes(parent.getNodes().get(5)) + amountNodes(parent.getNodes().get(6)) + amountNodes(parent.getNodes().get(7));
		}
	}
	
	@Override
	public String toString() {
		if (root == null) {
			return "Empty Path.";
		}
		else {
			
		}
	}
	
}
