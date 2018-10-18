package leetcode.dfs;

/**
 * 
 * Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

 * @author habhavsar
 * @since 2.5
 *
 */
public class PopulatingNextRightPointersII117 {
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right = new TreeLinkNode(3);
//		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);

		new PopulatingNextRightPointersII117().connect(root);
	}

	public void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}

		TreeLinkNode dummyRoot = new TreeLinkNode(0);
		TreeLinkNode current = null;
		while (root != null) {
			current = dummyRoot;
			while (root != null) {

				if (root.left != null) {
					current.next = root.left;
					current = current.next;
				}

				if (root.right != null) {
					current.next = root.right;
					current = current.next;
				}
				root = root.next;
			}
			root = dummyRoot.next;
			dummyRoot.next = null;
		}
	}
	

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	

}
