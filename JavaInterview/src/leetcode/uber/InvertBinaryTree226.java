package leetcode.uber;

public class InvertBinaryTree226 {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return root;
		}

		root.left = invertTree(root.left);
		root.right = invertTree(root.right);

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		return root;
	}

	class TreeNode {
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
