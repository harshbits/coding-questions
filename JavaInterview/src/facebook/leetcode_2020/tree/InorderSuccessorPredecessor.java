package facebook.leetcode_2020.tree;

public class InorderSuccessorPredecessor {

    public static void main(String[] args) {

    }

    // Time: O(h)
    // Space: O(h), best O(1)
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    // Time: O(h)
    // Space: O(h), best O(1)
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
