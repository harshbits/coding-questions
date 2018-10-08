package leetcode.dfs;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}
		// if (root.left == null || root.right == null) {
		// 	return 1 + minDepth(root.left) + minDepth(root.right);
		// }
		if (root.left == null && root.right == null) {
			return 1;
		}

		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};