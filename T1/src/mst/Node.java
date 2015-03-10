package mst;

public class Node {
	private int key;
	private final int number;
	private Node parent;

	public Node(int number) {
		this.number = number;
	}

	public void setKey(int k) {
		this.key = k;
	}

	public int getKey() {
		return this.key;
	}

	public void setParent(Node n) {
		this.parent = n;
	}
	
	public Node getParent() {
		return this.parent;
	}

	public int getNumber() {
		return this.number;
	}
	
	@Override
	public String toString() {
		return "(" + number + ")";
	}

}
