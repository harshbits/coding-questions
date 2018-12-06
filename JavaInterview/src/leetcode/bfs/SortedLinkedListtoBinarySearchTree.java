package leetcode.bfs;

public class SortedLinkedListtoBinarySearchTree {

	public static void main(String[] args) {

	}

	// In order traversal
	// always turns out to be sorted for the tree
	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) {
			return null;
		}

		int size = 0;
		ListNode runner = head;
		ListNode[] node = new ListNode[1];
		node[0] = head;

		// get the size of the linked list
		while (runner != null) {
			runner = runner.next;
			size++;
		}

		// in order traversal to tree node
		return toBSTInOrder(0, size - 1, node);
	}

	private TreeNode toBSTInOrder(int start, int end, ListNode[] node) {

		if (start > end) {
			return null;
		}

		// left -> root -> right = in order

		int mid = start + (end - start) / 2;

		// LEFT
		TreeNode left = toBSTInOrder(start, mid - 1, node);

		// ROOT
		TreeNode treenode = new TreeNode(node[0].val);
		treenode.left = left;
		node[0] = node[0].next;

		// RIGHT
		TreeNode right = toBSTInOrder(mid + 1, end, node);
		treenode.right = right;
		return treenode;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
