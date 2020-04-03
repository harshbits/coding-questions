package facebook.leetcode_2020.trie;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

    }

    // Time: O(N); N = number of nodes
    // Space: O(H); height of the tree
    // worst case H = N.
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxSumDFS(root, max);
        return max[0];
    }

    private int maxSumDFS(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftTree = Math.max(0, maxSumDFS(root.left, max));
        int rightTree = Math.max(0, maxSumDFS(root.right, max));

        max[0] = Math.max(max[0], leftTree + rightTree + root.val);
        return Math.max(leftTree, rightTree) + root.val;
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

//   1
//2     3

//left = 2
//right = 3
//
//max = (0, , 2 + 3 + 1)
//max = 6
//
//return 4
