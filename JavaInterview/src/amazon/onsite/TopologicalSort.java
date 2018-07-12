package amazon.onsite;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	private int V; // No. of vertices

	private LinkedList<Integer> adj[]; // Adjacency List

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	
	
	// Constructor
	@SuppressWarnings("unchecked")
	TopologicalSort(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}

	void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {

		// Mark the current node as visited.
		visited[v] = true;

		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			int i = it.next();
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		// Push current vertex to stack which stores result
		stack.push(v);

	}

	void topologicalSort() {
		Stack<Integer> stack = new Stack<>();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to store
		// Topological Sort starting from all vertices
		// one by one

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		// Print contents of stack
		while (stack.empty() == false) {
			System.out.print(stack.pop() + " ");
		}
	}

}
