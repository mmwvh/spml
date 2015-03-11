package mst;

import java.util.Random;

public class CompleteGraph extends Graph {
	/**
	 * Creates a complete graph with n nodes and connections between all nodes.
	 * The weight of those connections are random or fixed, depending on boolean
	 * random.
	 * 
	 * @param n
	 */
	public CompleteGraph(int n, boolean random) {
		super();
		for (int i = 0; i < n; i++) {
			nodeslist.add(new Node(i));
		}
		Random ran = new Random();
		int weight = 8;
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (noConnection(nodeslist.get(j), nodeslist.get(k))) {
					if (random) {
						weight = ran.nextInt(100);
					}
					edgeslist.add(new Edge(j, k, weight));
				}
			}
		}
	}

	private boolean noConnection(Node n, Node m) {
		for (Edge e : edgeslist) {
			if (e.connects(n, m)) {
				return false;
			}
		}
		return true;
	}

}
