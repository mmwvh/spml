package mst;

public class Edge {
	private int n1;
	private int n2;
	private int weight;

	public Edge(int n1, int n2, int weight) {
		this.n1 = n1;
		this.n2 = n2;
		this.weight = weight;
	}
	
	public boolean connects(Node n, Node m) {
		if (n.getNumber() == n1 && m.getNumber() == n2 || n.getNumber() == n2 && m.getNumber() == n1) {
			return true;
		}
		return false;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return "\n(" + this.n1 + ") ----" + this.weight + "---- (" + this.n2 + ")";
	}
}
