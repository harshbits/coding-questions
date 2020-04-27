package facebook.leetcode_2020.tree;

public class BinaryTreeToDoublyLinkedList {

    public static void main(String[] args) {

    }

    // the smallest (first) and the largest (last) nodes
    private Node first = null;
    private Node last = null;

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return root;
        }
        // dfs
        dfs(root);

        // Make it circular
        last.right = first;
        first.left = last;
        return root;
    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        // last will be null until we go left most first time.
        if (last != null) {
            // link the previous node (last)
            // with the current one (node)
            last.right = node;
            node.left = last;

        } else {
            // keep the smallest node
            // to close DLL later on
            first = node;
        }

        last = node;

        dfs(node.right);
    }


    // Definition for a Node.
    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
