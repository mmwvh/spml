package mst;

import java.util.ArrayList;

public class PrimMSTFinder {
	private int timer = 0;

	/**
	 * Returns a graph representation of a minimal spanning tree in graph g.
	 * 
	 * @param g
	 *            Connected graph g
	 * @return
	 */
	public MSTGraph find(Graph g) {
		g.initialize();
		ArrayList<Node> queue = g.getNodes();
		MSTGraph mst = new MSTGraph();
		while (!queue.isEmpty()) {
			Node min = getMin(queue, true);
			mst.addNode(min);
			if (min.getParent() != null) {
				mst.addEdge(new Edge(min.getNumber(), min.getParent()
						.getNumber(), min.getKey()));
			}
			for (Node n : g.getSuccessors(min)) {
				if (queue.contains(n) && g.getWeightEdge(min, n) < n.getKey()) {
					queue.get(queue.indexOf(n)).setParent(min);
					queue.get(queue.indexOf(n)).setKey(g.getWeightEdge(min, n));
				}
			}

		}
		return mst;
	}

	/**
	 * Returns the least
	 * 
	 * @param list
	 *            The list in which to search for the lowest value.
	 * @param remove
	 *            If set to true, the lowest value in the list will be returned
	 *            AND removed.
	 * @return
	 */
	public Node getMin(ArrayList<Node> list, boolean remove) {
		int min_index = 0;
		int min_key = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKey() < min_key) {
				min_key = list.get(i).getKey();
				min_index = i;
				timer++;
			}
		}
		if (remove) {
			return list.remove(min_index);
		} else {
			return list.get(min_index);
		}
	}

	public int getTimer() {
		return this.timer;
	}
}
