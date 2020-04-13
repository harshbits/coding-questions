package facebook.leetcode_2020.trie;

public class DiameterOfTree {
    public static void main(String[] args) {

    }

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    //Time: O(N)
    //Space: O(N)
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
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