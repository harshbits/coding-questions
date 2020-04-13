package facebook.leetcode_2020.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeIterator {

    private Deque<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        // Pushing all left or right nodes, will make space
        // O(h) ; h = height
        // Push all left nodes, as those are smaller.

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.poll();
        // Take the smallest element and take it's right sub tree.
        // which is bigger than smaller but smaller than it's root.
        pushAllLeft(node.right);
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
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
