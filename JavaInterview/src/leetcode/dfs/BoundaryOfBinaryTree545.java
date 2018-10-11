package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1
Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
Example 2
Input:
    ____1_____
   /          \
  2            3
 / \          / 
4   5        6   
   / \      / \
  7   8    9  10  
       
Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 * 
 * @author habhavsar
 *
 */
public class BoundaryOfBinaryTree545 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		var ans = new BoundaryOfBinaryTree545().boundaryOfBinaryTree(root);
		System.out.println(ans);
	}

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		ans.add(root.val);

		// first is always left in DFS
		preOrderTraverse(root.left, ans, true, false);
		// Right Boundary
		preOrderTraverse(root.right, ans, false, true);

		return ans;
	}

	private void preOrderTraverse(TreeNode node, List<Integer> ans, boolean isLeftBoundary, boolean isRightBoundary) {
		if (node == null) {
			return;
		}

		// Leaf Node, when there is no more child
		if (node.left == null && node.right == null) {
			ans.add(node.val);
			return;
		}

		// Left Boundary
		if (isLeftBoundary) {
			// add before traversal of rest
			ans.add(node.val);
			// if left node is not null
			preOrderTraverse(node.left, ans, node.left != null, false);
			// if left node is null,
			preOrderTraverse(node.right, ans, node.left == null, false);
		}

		// Rest of the middle nodes
		if (!isLeftBoundary && !isRightBoundary) {
			preOrderTraverse(node.left, ans, false, false);
			preOrderTraverse(node.right, ans, false, false);
			return;
		}

		// Right Boundary
		if (isRightBoundary) {
			// if left node is not null
			preOrderTraverse(node.left, ans, false, node.right == null);
			// if left node is null,
			preOrderTraverse(node.right, ans, false, node.right != null);
			// add after traversal of rest
			ans.add(node.val);
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
