package amazon;

public class MergeBalancedBinaryTree {

	public static void main(String[] args) {

	}

	TreeNode root;

	// head --> Pointer to head node of created doubly linked list
	TreeNode head;

	// Initialize previously visited node as NULL. This is
	// static so that the same value is accessible in all recursive
	// calls
	static TreeNode prev = null;

	void BinaryTree2DoubleLinkedList(TreeNode root) {
		// Base case
		if (root == null)
			return;

		// Recursively convert left subtree
		BinaryTree2DoubleLinkedList(root.left);

		// Now convert this node
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		// Finally convert right subtree
		BinaryTree2DoubleLinkedList(root.right);
	}

	// 1.Convert the two tree into doubly linked list.(sorted).
	// 2.Merge the two sorted list.
	// 3.Build a tree out of it.

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		// if (t1 == null && t2 == null) {
		// return null;
		// }

		if (t1 == null) {
			return t2;
		}

		if (t2 == null) {
			return t1;
		}

		// Using Recursion= tree traversal = DFS
		// int value = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
		int value = t1.val + t2.val;

		TreeNode mergedNode = new TreeNode(value);

		mergedNode.left = mergeTrees(t1.left, t2.left);

		mergedNode.right = mergeTrees(t1.right, t2.right);

		return mergedNode;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}

}
