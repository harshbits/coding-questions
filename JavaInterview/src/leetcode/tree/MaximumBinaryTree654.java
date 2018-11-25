package leetcode.tree;

import java.util.Arrays;

public class MaximumBinaryTree654 {

	public static void main(String[] args) {

	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructTree(nums, 0, nums.length);
	}

	
	private TreeNode constructTree(int[] nums, int start, int end) {
		if(start == end) {
			return null;
		}

//		int max = nums[start];
//		int maxIndex = start;
//		for (int i = start + 1; i < end; i++) {
//			if (nums[i] > max) {
//				max = nums[i];
//				maxIndex = i;
//			}
//		}
		int maxIndex = getMaxIndex(nums, start, end);

		TreeNode root = new TreeNode(nums[maxIndex]);

		root.left = constructTree(nums, start, maxIndex);

		root.right = constructTree(nums, maxIndex + 1, end);

		return root;
	}

	
//	private int getMax(int[] nums) {
//		int max = nums[0];
//		for (int i = 1; i < nums.length; i++) {
//			max = Math.max(max, nums[i]);
//		}
//		return max;
//	}
	
	private int getMaxIndex(int[] nums, int start, int end) {
		int maxIndex = start;
		for (int i = start; i < end; i++) {
			if (nums[maxIndex] < nums[i]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}