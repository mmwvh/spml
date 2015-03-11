package mst;

import java.util.Random;

public class CompleteGraph extends Graph {
	private int edges = 0;

	/**
	 * Creates a complete graph with n nodes and connections between all nodes.
	 * The weight of those connections are random or fixed, depending on boolean
	 * random.
	 * 
	 * @param n
	 *            The number of nodes in the connected graph
	 * @param random
	 *            Determines if a random weights initialization is used or a
	 *            fixed weight initialization. When set to true, disables the
	 *            stanweight parameter.
	 * @param stanweight
	 *            The standard weight of each edge if the random parameter is
	 *            set to false.
	 * @param mod
	 *            Determines the frequency in which the edges are added to the
	 *            graph. When set to 1, all the edges are added to the graph.
	 *            The higher the value, the lower the number of nodes added to
	 *            the edgeslist. Example: when set to 4, adds one in 4 edges to
	 *            the graph.
	 */
	public CompleteGraph(int n, boolean random, int stanweight, int mod) {
		super();
		for (int i = 0; i < n; i++) {
			nodeslist.add(new Node(i));
		}
		// Create a random object for use later.
		Random ran = new Random();
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (noConnection(nodeslist.get(j), nodeslist.get(k))) {
					// get a random weight if the random variable is set
					if (random) {
						stanweight = ran.nextInt(100) + 1;
					}
					// Divide the weight by mod. If there's a remainder, don't
					// add it to the list of edges.
					if (stanweight % mod == 0) {
						this.edges++;
						edgeslist.add(new Edge(j, k, stanweight));
					}

				}
			}
		}
	}

	/**
	 * Returns is there is NOT a connection between node n and node m.
	 * 
	 * @param n
	 *            Node n
	 * @param m
	 *            Node m
	 * @return True if the nodes are not connected.
	 */
	private boolean noConnection(Node n, Node m) {
		for (Edge e : edgeslist) {
			if (e.connects(n, m)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * returns the number of edges in the list of edges.
	 * 
	 * @return
	 */
	public int getNumEdges() {
		return this.edges;
	}

}
