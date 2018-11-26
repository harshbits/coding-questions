package leetcode.tree;

/**
 * 
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, 
 * insert the value into the BST. 
 * Return the root node of the BST after the insertion. 
 * It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, 
as long as the tree remains a BST after insertion. You can return any of them.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
You can return this binary search tree:

         4
       /   \
      2     7
     / \   /
    1   3 5
This tree is also valid:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
 * 
 * 
 * @author habhavsar
 *
 */
public class InsertIntoBST701 {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		
		// This will initialize in each recursive call.
		// Moving inside if condition will make it faster.
//		TreeNode newNode = new TreeNode(val);
		
//		if(root == null) return newNode;
		
		if (root == null) {
			root = new TreeNode(val);
			return root;
		}
		
		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		}else {
			root.right = insertIntoBST(root.right, val);
		}
		
		return root;
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

	};

}
