package amazon.onsite;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

 * @author hbhavsar
 *
 */
public class InorderTraversal {

	public static void main(String[] args) {
		
		
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {
			
			while (current != null) {
				stack.add(current);
				current = current.left;
			}
			current = stack.pop();
			traversal.add(current.val);
			current = current.right;
		}
		
		return traversal;
	}
	
}

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}
