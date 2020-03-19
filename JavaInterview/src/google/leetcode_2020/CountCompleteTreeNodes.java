package google.leetcode_2020;

public class CountCompleteTreeNodes {


    public static void main(String[] args) {
        new CountCompleteTreeNodes().test();
    }

    private void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        int ans = countNodes(root);
        System.out.println(ans);
    }


    // O(n)
    // O(n log n ) space
//    public int countNodes(TreeNode root) {
//        return root != null ? countNodes(root.left) + countNodes(root.right) + 1 : 0;
//    }


    // Time = O (2 ^ d) = d => depth of the tree
    // Space = O (1) constant
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth = findDepth(root);
        // if the tree contains 1 node
        if (depth == 0) {
            return 1;
        }

        int low = 1;
        int high = (int) Math.pow(2, depth);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (exists(mid, depth, root)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) Math.pow(2, depth) - 1 + low;
    }


    public boolean exists(int idx, int depth, TreeNode node) {
        int low = 0;
        int high = (int) Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; ++i) {
            int mid = low + (high - low) / 2;
            if (idx <= mid) {
                node = node.left;
                high = mid;
            } else {
                node = node.right;
                low = mid + 1;
            }
        }
        return node != null;
    }


//    private int findDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
//    }

    // only for complete final depth
    private int findDepth(TreeNode root) {
        int d = 0;
        //
        while (root.left != null) {
            root = root.left;
            d++;
        }
        return d;
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
