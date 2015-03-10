package mst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {

	protected ArrayList<Node> nodeslist;
	protected ArrayList<Edge> edgeslist;

	private Node startnode;

	/**
	 * Initializes a new graph according the nodes in the list of nodes and the
	 * edges in the list of edges.
	 * 
	 * @param nodes
	 *            The list of nodes.
	 * @param edges
	 *            The list of edges.
	 */
	public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
		this.nodeslist = nodes;
		this.edgeslist = edges;
	}

	/**
	 * Initialize an empty graph
	 */
	public Graph() {
		nodeslist = new ArrayList<Node>();
		edgeslist = new ArrayList<Edge>();
	}

	/**
	 * Returns all nodes which are not in the queue
	 * 
	 * @param n
	 * @return
	 */
	public ArrayList<Node> getSuccessors(Node n) {
		ArrayList<Node> list = new ArrayList<Node>();
		for (Edge e : edgeslist) {
			for (Node successor : nodeslist) {
				if (e.connects(n, successor)) {
					list.add(successor);
				}
			}
		}

		return list;
	}

	public int getWeightEdge(Node n, Node m) {
		for (Edge e : edgeslist) {
			if (e.connects(n, m)) {
				return e.getWeight();
			}
		}
		return 0;
	}

	public int getDestinationNode(Node n, int weight) {
		for (Node node : nodeslist) {
			for (Edge e : edgeslist) {
				if (e.connects(n, node)) {
					System.out.print("BLA");
					if (e.getWeight() == weight) {
						System.out.print("BOE");
						return node.getNumber();
					}
				}

			}
		}
		return -1;
	}

	public void initialize() {
		for (Node node : nodeslist) {
			node.setKey(Integer.MAX_VALUE);
			node.setParent(null);
		}
		Random r = new Random();
		int startnode = r.nextInt(nodeslist.size());
		nodeslist.get(startnode).setKey(0);
		this.startnode = nodeslist.get(startnode);
	}

	public Node getStartNode() {
		return startnode;
	}

	public ArrayList<Node> getNodes() {
		return this.nodeslist;
	}

	public ArrayList<Edge> getEdges() {
		return edgeslist;
	}
}
