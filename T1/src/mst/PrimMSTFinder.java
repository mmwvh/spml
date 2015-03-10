package mst;

import java.util.ArrayList;

public class PrimMSTFinder {

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

	public Node getMin(ArrayList<Node> list, boolean remove) {
		int min_index = 0;
		int min_key = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKey() < min_key) {
				min_key = list.get(i).getKey();
				min_index = i;
			}
		}
		if (remove) {
			return list.remove(min_index);
		} else {
			return list.get(min_index);
		}
	}
}
