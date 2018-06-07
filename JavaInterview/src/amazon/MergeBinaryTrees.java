package amazon;

/**
 * 
 * Given two binary trees and imagine that when you put one of them to cover the
 * other, some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two
 * nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * 
 * @author hbhavsar
 *
 */
public class MergeBinaryTrees {

	public static void main(String[] args) {
		new MergeBinaryTrees().process();

	}

	public void process() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t1l = new TreeNode(3);
		t1.left = t1l;

		TreeNode t1r = new TreeNode(2);
		t1.right = t1r;

		TreeNode t1ll = new TreeNode(5);
		t1l.left = t1ll;

		TreeNode t2 = new TreeNode(2);
		TreeNode t2l = new TreeNode(1);
		t2.left = t2l;

		TreeNode t2lr = new TreeNode(4);
		t2l.right = t2lr;

		TreeNode t2r = new TreeNode(3);
		t2.right = t2r;

		TreeNode t2rr = new TreeNode(7);
		t2r.right = t2rr;

		TreeNode ans = mergeTrees(t1, t2);

		System.out.println(ans);
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if (t1 == null && t2 == null) {
			return null;
		}

		if (t1 == null) {
			return t2;
		}

		if (t2 == null) {
			return t1;
		}

		// Using Recursion= tree traversal = DFS
		int value = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);

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
