package facebook.leetcode_2020.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinumDepthOfTree {


    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null || root.right == null) {
            return 1 + minDepth(root.left) + minDepth(root.right);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }


    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // for each level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    int min = Integer.MAX_VALUE;

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            min = Math.min(min, depth + 1);
            return;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
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
