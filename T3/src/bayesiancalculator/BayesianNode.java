package bayesiancalculator;

import java.util.ArrayList;
import java.util.Hashtable;

public class BayesianNode {
	private ArrayList<BayesianNode> parents;
	private String name;	
	private Hashtable<String, Double> distribution;
	
	public BayesianNode(ArrayList<BayesianNode> parents, String name, Hashtable<String, Double> distribution) {
		this.name = name;
		this.parents = parents;
		this.distribution = distribution;		
		
	}
	
	public Double getProb(String query) {
		return distribution.get(query);		
	}

	
}
