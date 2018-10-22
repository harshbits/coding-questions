package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Seen this question in a real interview before?  

 * 
 * @author habhavsar
 *
 */
public class BSTIterator173 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(2);
		node.right = new TreeNode(4);
		BSTIterator173 b = new BSTIterator173(node);
		while (b.hasNext()) {
			System.out.println(b.next());
		}
	}

//	private TreeNode root;

	private Deque<TreeNode> stack;

	public BSTIterator173(TreeNode root) {
//		this.root = root;
		this.stack = new ArrayDeque<>();
		// Pushing all left or right nodes, will make space
		// O(h) ; h = height
		// Push all left nodes, as those are smaller.
		pushAllLeft(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pollFirst();
		// Take the smallest element and take it's right sub tree.
		// which is bigger than smaller but smaller than it's root.
		pushAllLeft(node.right);
		return node.val;
	}

	private void pushAllLeft(TreeNode root) {
		while (root != null) {
			this.stack.offerFirst(root);
			root = root.left;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
