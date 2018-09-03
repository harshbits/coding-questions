package google.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * 
 * @author hbhavsar
 *
 */
public class BinaryTreePaths257 {

	
	public static void main(String[] args) {
		BinaryTreePaths257 b = new BinaryTreePaths257();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		List<String> ans = b.binaryTreePaths(root);
		System.out.println(ans);
	}

	public List<String> binaryTreePaths(TreeNode root) {

		List<String> paths = new ArrayList<>();

		if (root == null) {
			return paths;
		}

		if (root.left == null && root.right == null) {
			paths.add(root.val + "");
			return paths;
		}

		for (String path : binaryTreePaths(root.left)) {
			paths.add(root.val + "->" + path);
		}

		for (String path : binaryTreePaths(root.right)) {
			paths.add(root.val + "->" + path);
		}

		return paths;
	}
	
	
//	public void dfsUtil(TreeNode root, List<String> paths, StringBuilder sb) {
//		if (root == null) {
//			return;
//		}
//		
//		if(root.left == null && root.right == null) {
//			if (sb.length() > 0) {
//				paths.add(sb.toString());
//				// sb.setLength(0);
//				sb = new StringBuilder();
//			}
//			return;
//		}
//		
//		sb.append(root.val).append("->");
//		
//		dfsUtil(root.left, paths, sb);
//		dfsUtil(root.right, paths, sb);
//		
//	}
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}