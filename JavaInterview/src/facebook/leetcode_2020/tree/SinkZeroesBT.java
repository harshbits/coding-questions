package facebook.leetcode_2020.tree;

import java.util.Stack;

public class SinkZeroesBT {

    public static void main(String[] args) {
        new SinkZeroesBT().test();
    }

    private void test() {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(0);
        node.right.right = new TreeNode(2);
        node.right.left = new TreeNode(0);
        node.right.left.left = new TreeNode(3);
        node.right.left.right = new TreeNode(4);

        printPostOrder(node);
        System.out.println();
        sinkZeroesInBinaryTree(node);
        printPostOrder(node);
    }

    // O(n) time, n = number of nodes.
    public void sinkZeroesInBinaryTree(TreeNode node) {
        // space
        // worst case all nodes
        // best case no nodes, since everything is zero.
        Stack<Integer> stack = new Stack<>();
        int[] totalZero = new int[1];
        dfs(node, stack, totalZero);
    }

    // O(n) space
    // O(n) time
    private void dfs(TreeNode node, Stack<Integer> stack, int[] totalZero) {
        if (node == null) {
            return;
        }

        if (node.value == 0) {
            totalZero[0]++;
        } else {
            stack.push(node.value);
        }

        dfs(node.left, stack, totalZero);
        dfs(node.right, stack, totalZero);

        if (totalZero[0] > 0) {
            node.value = 0;
            totalZero[0]--;
        } else {
            node.value = stack.pop();
        }
    }

    private void printPostOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " -> ");
    }

    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
