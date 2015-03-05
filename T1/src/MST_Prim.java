/**
 * Artificial Intelligence: Search, Planning and Machine Learning
 * 
 * @author Haye Böhm / s
 * @author Wesley van Hoorn / s4018044
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_Prim {

	private final Integer inf = Integer.MAX_VALUE;
	private PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
	private ArrayList<Vertex> t = new ArrayList<Vertex>(); // Minimal Spanning Tree

	public MST_Prim(Graph g, Vertex r) {

		for (Vertex u : g.getVertices()) {
			u.setKey(inf);
			u.setParent(null);
		}
		r.setKey(0);
		q.addAll(g.getVertices());

		while (!q.isEmpty()) {
			Vertex u = q.poll();

			for (Vertex v : g.getNeigbours(u)) {
				if (q.contains(v)) {
					if (g.getWeight(u, v) < v.getKey()) {
						q.remove(v);
						v.setParent(u);
						v.setKey(g.getWeight(u, v));
						q.add(v);
					}
				}
			}
			t.add(u);
		}
	}
}
