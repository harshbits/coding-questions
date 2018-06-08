package amazon;

import java.util.Stack;

public class FlattenBinaryTree {

	public static void main(String[] args) {

	}

	// Using Reccursion
	TreeNode prev = null;

	public void flatten(TreeNode root) {
		helper(root);
	}

	private void helper(TreeNode node) {
		if (node == null)
			return;
		if (prev != null) {
			prev.left = null; // set left to null, as we do not need left nodes
			prev.right = node;
		}
		TreeNode temp = node.right; // right will be changed in next recursive calls
		prev = node;
		helper(node.left);
		helper(temp);

	}

	public void flattenNoRec(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		TreeNode prev = null, curr = null;
		while (!s.isEmpty()) {
			curr = s.pop();
			if (prev != null) {
				prev.right = curr;
				prev.left = null;
			}
			if (curr.right != null)
				s.push(curr.right);
			if (curr.left != null)
				s.push(curr.left);
			prev = curr;
		}
		curr.right = null;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}
}
