package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	public Map<Integer, UndirectedGraphNode> hashMap = new HashMap<Integer, UndirectedGraphNode>();
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null) {
			return null;
		}

		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
//		cloneNode.neighbors = node.neighbors;
		hashMap.put(node.label, cloneNode);
		for (UndirectedGraphNode neighbor: node.neighbors) {
			UndirectedGraphNode neighborClone = hashMap.get(neighbor.label);
//			UndirectedGraphNode neighborClone = hashMap.get(neighbor.label);
			cloneNode.neighbors.add(neighborClone == null ? cloneGraph(neighbor) : neighborClone);
		}
		
		return cloneNode;
	}
}

/**
 * Definition for undirected graph.
 */
class UndirectedGraphNode {

	int label;

	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	// public int getLabel() {
	// return label;
	// }
	//
	// public void setLabel(int label) {
	// this.label = label;
	// }
	//
	// public List<UndirectedGraphNode> getNeighbors() {
	// return neighbors;
	// }
	//
	// public void setNeighbors(List<UndirectedGraphNode> neighbors) {
	// this.neighbors = neighbors;
	// }

}