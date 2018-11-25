package amazon;

/**
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary search tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * _______3______ / \ ___5__ ___1__ / \ / \ 6 _2 0 8 / \ 7 4 Example 1:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3. Example 2:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition. Note:
 * 
 * All of the nodes' values will be unique. p and q are different and both
 * values will exist in the binary tree.
 * 
 * @author hbhavsar
 *
 */
public class LeastCommonAncestorBST {

	public static void main(String[] args) {
		LeastCommonAncestorBST l = new LeastCommonAncestorBST();
		l.helper();
	}

	public void helper() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(3);

		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(4);

		TreeNode ans = lowestCommonAncestor(root, p, q);
		System.out.println(ans);
	}

	// * Time complexity O(height of tree)
	// * Space complexity O(height of tree)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Validations
		if (root == null || p == root || q == root) {
			return root;
		}

		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
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
