package facebook.leetcode_2020.tree;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewTree {

    public static void main(String[] args) {

        new RightSideViewTree().test();

    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        var ans = rightSideView(root);
        System.out.println(ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        dfs(root, rightViewList, 0);
        return rightViewList;
    }


    // O(n) time
    // O(n) space
    private void dfs(TreeNode node, List<Integer> rightViewList, int level) {
        if (node == null) {
            return;
        }
        // if we haven't added node for level
        if (rightViewList.size() <= level) {
            rightViewList.add(node.val);
        }
        // update the index with latest, we always visit right later.
        else {
            rightViewList.set(level, node.val);
        }

        dfs(node.left, rightViewList, level + 1);

        dfs(node.right, rightViewList, level + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
