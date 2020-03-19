package google.leetcode_2020;

public class FlipEquivalentBTs {



    // Time = O(min(n1, n2)) = n = number of nodes
    // Space = O(min(h1, h2)) = h = height/depth of the tree
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == root2) {
            return true;
        }
        // since we can not swap roots
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        // check with left and right
        // or
        // left right and right left
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

/*
    public boolean flipEquivHelper(TreeNode root1, TreeNode root2) {

    }
*/


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
