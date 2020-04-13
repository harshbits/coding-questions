package facebook.leetcode_2020.tree;


public class SmallestSubTreeDeepestNodes {

    public static void main(String[] args) {
        new SmallestSubTreeDeepestNodes().tesy();
    }

    //3,5,1,6,2,0,8,null,null,7,4
    private void tesy() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode ans = subtreeWithAllDeepest(root);
        printPreOrder(ans);
    }

    // Time: O(N)
    // Space: O(N)
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private NodeData dfs(TreeNode root) {
        if (root == null) {
            return new NodeData(null, 0);
        }

        NodeData left = dfs(root.left);
        NodeData right = dfs(root.right);

        //leftHeight == rightHeight, it means we have found the deepest subtree
        // rooted at node.
        // if both are same then return left
        if (left.depth == right.depth) {
            return new NodeData(root, left.depth + 1);
        } else if (left.depth > right.depth) {
            // return the one with max depth
            left.depth++;
            return left;
        } else {
            right.depth++;
            return right;
        }
    }

    private class NodeData {
        TreeNode node;
        Integer depth;

        public NodeData(TreeNode node, Integer depth) {
            this.node = node;
            this.depth = depth;
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

    private void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " -> ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
