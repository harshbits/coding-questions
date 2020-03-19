package google.leetcode_2020;

import java.util.Stack;

public class EqualTreePartition {

    public static void main(String[] args) {

        new EqualTreePartition().test();
    }

    private void test() {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        root.right.left = new TreeNode(6);

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(-1);

        boolean ans = checkEqualTree(root);
        System.out.println(ans);
    }


    public boolean checkEqualTree(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (root.left == null && root.right == null) {
//            return false;
//        }
        int totalSum = sumOfTheTree(root);
//        System.out.println(totalSum);
        if (totalSum % 2 != 0) {
            return false;
        }

        return dfsHelper(root.left, totalSum / 2) || dfsHelper(root.right, totalSum / 2);
    }

    private boolean dfsHelper(TreeNode node, int target) {

        if (node == null) {
            return false;
        }

        int left = sumOfTheTree(node.left);
        int right = sumOfTheTree(node.right);

        if (node.val + left + right == target) {
            return true;
        }

        return dfsHelper(node.left, target) || dfsHelper(node.right, target);
    }

//    public boolean checkEqualTree(TreeNode root) {
//        Stack<Integer> visited = new Stack<>();
//        int totalSum = sumOfTheTree(root, visited);
//        System.out.println(totalSum);
//
//        // if total sum is not even then we can not divide equally
//        if (totalSum % 2 == 0) {
//            for (int s : visited) {
//                // for all sum
//                // stop when sum is divided by 2.
//                if (s == totalSum / 2) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


//    private int sumOfTheTree(TreeNode root, Stack<Integer> visited) {
//        if (root == null) {
//            return 0;
//        }
//        visited.push(root.val + sumOfTheTree(root.left, visited) + sumOfTheTree(root.right, visited));
//        return visited.peek();
//    }

    private int sumOfTheTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumOfTheTree(root.left) + sumOfTheTree(root.right);
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
