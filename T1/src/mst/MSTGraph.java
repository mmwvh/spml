package mst;

public class MSTGraph extends Graph {

	/**
	 * Initializes an empty minimal spanning tree graph.
	 */
	public MSTGraph() {
		super();
	}

	/**
	 * Adds edge e to the graph.
	 * 
	 * @param e
	 */
	public void addEdge(Edge e) {
		this.edgeslist.add(e);
	}

	/**
	 * Adds node n to the graph
	 * 
	 * @param n
	 */
	public void addNode(Node n) {
		this.nodeslist.add(n);
	}

	/**
	 * Returns the cost of the current graph., according to the weight in the
	 * edge list.
	 * 
	 * @return
	 */
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
