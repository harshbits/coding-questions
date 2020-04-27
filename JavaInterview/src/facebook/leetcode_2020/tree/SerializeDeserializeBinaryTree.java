package facebook.leetcode_2020.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeDeserializeBinaryTree {

    private static final String NULL = "null";

    private static final String DELIMETER = ",";

    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        searializeTreetoString(root, sb);
        return sb.toString();
    }

    // We will be doing pre order traversal
    // root -> left -> right
    private void searializeTreetoString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(DELIMETER);
        } else {
            sb.append(node.val).append(DELIMETER);

            // Left Sub Tree
            searializeTreetoString(node.left, sb);
            // Right Sub Tree
            searializeTreetoString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Add all comma separated values to queue
        // Using queue to store pre-order traversal.
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(DELIMETER)));

        // Build tree
        TreeNode tree = buildTree(nodes);

        return tree;
    }

    private TreeNode buildTree(Deque<String> nodes) {
        // Removes the head of the queue
        String value = nodes.remove();

        // Tree is empty
        if (value.equals(NULL)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(value));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
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
