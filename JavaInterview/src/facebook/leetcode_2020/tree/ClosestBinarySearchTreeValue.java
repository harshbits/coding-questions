package facebook.leetcode_2020.tree;

public class ClosestBinarySearchTreeValue {

    public static void main(String[] args) {
    }

    // Time: O(h); h = height
    // Space: O(1)
    public int closestValue(TreeNode root, double target) {

        if (root == null) {
            return 0;
        }

        int closest = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - closest)) {
                closest = root.val;

                // close enough to the target value,stop search.
                if (Math.abs(target - root.val) <= 0.5) {
                    break;
                }
            }
            // Use binary search property here
            root = root.val > target ? root.left : root.right;
        }
        return closest;
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
