package mst;

import java.util.ArrayList;

public class SPML1 {

	public static void main(String[] args) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node(0));
		nodes.add(new Node(1));
		nodes.add(new Node(2));
		nodes.add(new Node(3));
		nodes.add(new Node(4));
		nodes.add(new Node(5));
		nodes.add(new Node(6));
		nodes.add(new Node(7));
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
		
		
		Graph g = new Graph(nodes, edges);
		PrimMSTFinder finder = new PrimMSTFinder();
		MSTGraph mstg = finder.find(g);
		System.out.print("Tree cost: " + mstg.getTreeCost() + "\n" + mstg);
		System.out.print("Done within " + finder.getTimer() + " edge considerations!");
	}
	

}
