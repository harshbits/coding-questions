package facebook.leetcode_2020.tree;

public class ClosestElementInBinarySearchTree {

    //Time: O(h)
    //Space: O(1)
    public int closestValue(TreeNode root, double target) {

        int ret = root.val;

        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;
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
