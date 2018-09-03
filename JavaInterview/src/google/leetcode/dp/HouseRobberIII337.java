package google.leetcode.dp;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

 * 
 * @author hbhavsar
 *
 */
public class HouseRobberIII337 {
	
	public static void main(String[] args) {
		HouseRobberIII337 h = new HouseRobberIII337();
		//3,2,3,null,3,null,1]
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.right = new TreeNode(3);
//		root.right.right = new TreeNode(1);
		
		
		//[3,4,5,1,3,null,1]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		
		int ans = h.rob(root);
		System.out.println(ans);
	}
	
	
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}

		// results[0] => inclusive nodes
		// results[1] => inclusive nodes
		int[] results = robUtil(root);
		
		return Math.max(results[0], results[1]);
	}
	
	
	private int[] robUtil(TreeNode root) {
		
		if(root == null) {
			return new int[] { 0, 0 };
		}
		
		int[] results = new int[2];

		// get left inclusive and exclusive
		int[] left = robUtil(root.left);

		// get right inclusive and exclusive
		int[] right = robUtil(root.right);

		
		// results[0] is when root is selected,
		results[0] = root.val + left[1] + right[1];
		// results[1] is when root is not selected. 
		results[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		return results;
	}
	
	
	// Level order will not work
	    
//	    public int rob(int[] nums, int start, int end) {
//			int inclusive = 0;
//			int exclusive = 0;
////			if (end < 0) {
////				end = 0;
////			}
//
//			for (int i = start; i <= end; i++) {
//				int n = nums[i];
//				int temp = inclusive;
//				inclusive = Math.max(inclusive, exclusive + n);
//				exclusive = temp;
//			}
//			return inclusive;
//
//		}
//	    
//	    public int[] levelOrderSum(TreeNode root) {
////			int[] sum = new int[10];
//			List<Integer> sum = new ArrayList<>(10);
//			levelOrderSumUtil(root, sum, 0);
////			return sum.toArray();
//			return sum.stream().mapToInt(i -> i).toArray();
//		}
//		
////		private void levelOrderSumUtil(TreeNode root, int[] sum, int level) {
//		private void levelOrderSumUtil(TreeNode root, List<Integer> sum, int level) {
//			if(root == null) {
//				return;
//			}
////			sum[level] += root.val;
////			if(sum.size() == 0) {
////				sum.add(root.val);
////			}else {
////				sum.set(level, sum.get(level) + root.val);	
////			}
//			
////			if(sum.get(level) == null) {
//			if(sum.size() <= level) {
//				sum.add(root.val);
//			}else {
//				sum.set(level, sum.get(level) + root.val);
//			}
//			
//			levelOrderSumUtil(root.left, sum, level + 1);
//			levelOrderSumUtil(root.right, sum, level + 1);
//		}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
