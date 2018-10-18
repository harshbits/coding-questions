package leetcode.dfs;

public class BalancedBinaryTree110 {

//	public boolean isBalanced(TreeNode root) {
//
//		if (root == null) {
//			return true;
//		}
//
//		int left = maxDepth(root.left);
//		int right = maxDepth(root.right);
//
//		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//
//	}
//
//	private int maxDepth(TreeNode root) {
//		if (root == null) {
//			return 0;
//		}
//		int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//		return max;
//	}

	boolean ans = false;
	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

//		boolean ans = false;
		ans = true;
		maxDepthHelper(root);
		return ans;

	}

	private int maxDepthHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = maxDepthHelper(root.left);
		int right = maxDepthHelper(root.right);

		if (Math.abs(left - right) > 1) {
			ans = false;
		}

		return Math.max(left, right) + 1;
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
