package mst;

import java.util.ArrayList;

public class SPML1 {

	public static void main(String[] args) {
		//Graph g = customGraph();
		
		Graph g = new CompleteGraph(20, false);
		PrimMSTFinder finder = new PrimMSTFinder();
		
		long start = System.nanoTime();
		MSTGraph mstg = finder.find(g);
		long dif = System.nanoTime() - start;
		System.out.print("Tree cost: " + mstg.getTreeCost() + "\n" + mstg);
		System.out.print("Done within " + dif + " nano seconds");
	}
	
	public static Graph customGraph() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node(0));
		nodes.add(new Node(1));
		nodes.add(new Node(2));
		nodes.add(new Node(3));
		nodes.add(new Node(4));
		nodes.add(new Node(5));
		nodes.add(new Node(6));
		nodes.add(new Node(7));
		nodes.add(new Node(8));
		nodes.add(new Node(9));
		nodes.add(new Node(10));
		nodes.add(new Node(11));
		nodes.add(new Node(12));
		nodes.add(new Node(13));
		nodes.add(new Node(14));
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(0, 1, 7));
		edges.add(new Edge(0, 3, 5));
		edges.add(new Edge(1, 4, 7));
		edges.add(new Edge(1, 3, 9));
		edges.add(new Edge(1, 2, 8));
		edges.add(new Edge(1, 4, 7));
		edges.add(new Edge(2, 4, 5));
		edges.add(new Edge(3, 4, 15));
		edges.add(new Edge(3, 5, 6));
		edges.add(new Edge(4, 5, 8));
		edges.add(new Edge(4, 6, 9));
		edges.add(new Edge(5, 6, 11));
		edges.add(new Edge(7, 8, 9));
		edges.add(new Edge(6, 7, 8));
		edges.add(new Edge(6, 8, 7));
		edges.add(new Edge(6, 9, 5));
		edges.add(new Edge(8, 10, 15));
		edges.add(new Edge(8, 11, 6));
		edges.add(new Edge(11, 10, 8));
		edges.add(new Edge(10, 12, 9));
		edges.add(new Edge(12, 13, 11));
		edges.add(new Edge(13, 10, 26));
		edges.add(new Edge(13, 14, 8));
		edges.add(new Edge(14, 12, 9));
		edges.add(new Edge(14, 16, 11));
		
		return new Graph(nodes, edges);
	}
}
