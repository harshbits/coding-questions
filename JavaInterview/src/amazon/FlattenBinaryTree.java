package amazon;

import java.util.Stack;

public class FlattenBinaryTree {

	public static void main(String[] args) {

		new FlattenBinaryTree().helper();

	}

	// Using Reccursion
	TreeNode prev = null;

	public void helper() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(12);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(30);
		root.right.left = new TreeNode(36);

		flatten(root);
	}

	private void flatten(TreeNode node) {
		if (node == null)
			return;
		if (prev != null) {
			prev.left = null; // set left to null, as we do not need left nodes
			prev.right = node;
		}
		TreeNode temp = node.right; // right will be changed in next recursive calls
		prev = node;
		flatten(node.left);
		flatten(temp);

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
