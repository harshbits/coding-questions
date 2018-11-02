package leetcode.dfs;

public class ConstructPreorerToInorder105 {

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
	}

	int pi = 1;
	int ii = 0;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		
		// root.
		TreeNode root = new TreeNode(preorder[0]);
		
		
		
		
		return root;

	}
	
	public void buildTree(TreeNode root, int[] preorder, int[] inorder, int pi, int ii) {
		
		if (root != null) {
			if (preorder[pi] == inorder[pi - 1]) {
				root.left = new TreeNode(preorder[pi]);
				pi++;
			}

		}
		
	}
}
