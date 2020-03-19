package google.leetcode_2020.tree;

public class RedBlackTree {

	private static final boolean RED = true;
	
	private static final boolean BLACK = false;

	private class Node {
		private int key; // key
		private int val; // associated data
		private Node left, right; // links to left and right subtrees
		private boolean color; // color of parent link
		private int size; // subtree count

		public Node(int key, int val, boolean color, int size) {
			this.key = key;
			this.val = val;
			this.color = color;
			this.size = size;
		}
	}
}
