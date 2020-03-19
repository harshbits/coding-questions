package google.leetcode_2020;

import java.util.*;

public class DeleteNodeAndReturnForest {


    public static void main(String[] args) {

        new DeleteNodeAndReturnForest().test();

    }

    private void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> ans = delNodes(root, new int[]{3, 5});
        System.out.println(ans);

    }


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete) {
            toDelete.add(i);
        }
        if (!toDelete.contains(root.val)) {
            ans.add(root);
        }

//        dfs(root, toDelete, ans, true);
        dfs(root, toDelete, ans);
        return ans;
    }


    //    private TreeNode dfs(TreeNode node, Set<Integer> toDelete, List<TreeNode> list, boolean isRoot) {
    private TreeNode dfs(TreeNode node, Set<Integer> toDelete, List<TreeNode> list) {

        if (node == null) {
            return null;
        }

        // whether node to be deleted
        boolean deleted = toDelete.contains(node.val);
//        if (isRoot && !deleted) {
//            list.add(node);
//        }

//        node.left = dfs(node.left, toDelete, list, deleted);
//        node.right = dfs(node.right, toDelete, list, deleted);

        node.left = dfs(node.left, toDelete, list);
        node.right = dfs(node.right, toDelete, list);

        if (deleted) {
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
        return node;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}
