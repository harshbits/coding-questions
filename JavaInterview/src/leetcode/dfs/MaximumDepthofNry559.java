package leetcode.dfs;

import java.util.List;

/**
 * 
 * Given a n-ary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * For example, given a 3-ary tree:
 * 
 * @author habhavsar
 *
 */
public class MaximumDepthofNry559 {

	public static void main(String[] args) {
		List<Node> l = List.of(new Node(), new Node());
		Node node = new Node(0, l);
		int ans = new MaximumDepthofNry559().maxDepth(node);
		System.out.println(ans);
		
	}

	public int maxDepth(Node root) {
		
		if (root == null) {
			return 0;
		}
		if(root.children == null) {
			return 1;
		}
		int max = 0;
		for (Node node : root.children) {
			max = Math.max(max, maxDepth(node));
		}
		return max + 1;
	}

}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};
