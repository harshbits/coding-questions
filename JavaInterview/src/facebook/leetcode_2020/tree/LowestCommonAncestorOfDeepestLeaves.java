package facebook.leetcode_2020.tree;

public class LowestCommonAncestorOfDeepestLeaves {

    public static void main(String[] args) {

    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        NodeData data = dfs(root, 0);
        return data.node;
    }

    // Time: O(n)
    // Space: O(h); h = height
    private NodeData dfs(TreeNode root, int d) {
        if (root == null) {
            return new NodeData(null, d);
        }

        NodeData left = dfs(root.left, d + 1);
        NodeData right = dfs(root.right, d + 1);

        // if depth same then common ancestor
        if (left.depth == right.depth) {
            return new NodeData(root, left.depth);
        } else {
            // return deepest one
            return left.depth > right.depth ? left : right;
        }
    }

    private class NodeData {
        int depth;
        TreeNode node;

        NodeData(TreeNode node, int depth) {
            this.depth = depth;
            this.node = node;
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
