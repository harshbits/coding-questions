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
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 * @author habhavsar
 * @since 2.5
 *
 */
public class PopulatingNextRightPointers116 {
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right = new TreeLinkNode(3);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);

		new PopulatingNextRightPointers116().connect(root);
	}

	public void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}

		// root's next is null
		connect(root, null);

	}

	public void connect(TreeLinkNode root, TreeLinkNode next) {
		if (root == null) {
			return;
		}
//		System.out.print(root.val + "  ->  ");
//		System.out.print(next != null ? next.val : null);
//		System.out.println();
		root.next = next;

		connect(root.left, root.right);

		connect(root.right, next == null ? null : next.left);
	}
	
	
	public void connect2(TreeLinkNode root) {

		if (root == null || root.left == null) {
			return;
		}

		TreeLinkNode l = root.left;
		TreeLinkNode r = root.right;
		// connect all right-most nodes of left subtree to respective left-most nodes of
		// right subtree
		while (l != null) {
			l.next = r;
			l = l.right;
			r = r.left;
		}
		// left sub tree
		connect(root.left);
		// right sub tree
		connect(root.right);

	}
	
	
	

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	

}
