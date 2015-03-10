package mst;

public class MSTGraph extends Graph {

	public MSTGraph() {
		super();
	}

	public void addEdge(Edge e) {
		this.edgeslist.add(e);
	}

	public void addNode(Node n) {
		this.nodeslist.add(n);
	}

	public int getTreeCost() {
		int cost = 0;
		for (Edge e : edgeslist) {
			cost += e.getWeight();
		}
		return cost;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nodes: " + nodeslist + "\n");
		sb.append("Edges: " + edgeslist + "\n");
		
		return sb.toString();
	}
}
