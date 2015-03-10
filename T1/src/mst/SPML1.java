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
		nodes.add(new Node(8));
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(0, 1, 3));
		edges.add(new Edge(0, 2, 4));
		edges.add(new Edge(1, 2, 1));
		edges.add(new Edge(1, 3, 7));
		edges.add(new Edge(2, 4, 2));
		edges.add(new Edge(4, 5, 1));
		edges.add(new Edge(5, 7, 13));
		edges.add(new Edge(5, 6, 12));
		edges.add(new Edge(6, 7, 3));
		edges.add(new Edge(7, 8, 2));
		
		
		Graph g = new Graph(nodes, edges);
		PrimMSTFinder finder = new PrimMSTFinder();
		MSTGraph mstg = finder.find(g);
		System.out.print("Tree cost: " + mstg.getTreeCost() + "\n" + mstg);
		System.out.print("Done!");
	}
	

}
