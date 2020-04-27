package facebook.leetcode_2020.tree;

import Helper.ConvertArrayToTreeNode;
import Helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodeKDistance {

    public static void main(String[] args) {

        Integer[] root = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = ConvertArrayToTreeNode.arrayToTree(root);


    }

    // Time: O(n) + O(n) = 2 times DFS
    // Space: O(n) + O(n) = 2 times DFS
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        // Step 1. find the target node and allocate distance for each node from target
        Map<TreeNode, Integer> distanceMap = new HashMap<>();
        find(root, target, distanceMap);

        // Step 2. DFS to get answer for distance K
        List<Integer> ans = new ArrayList<>();
        dfs(root, K, distanceMap, distanceMap.get(root), ans);
        return ans;
    }

    private int find(TreeNode root, TreeNode target, Map<TreeNode, Integer> distanceMap) {
        if (root == null) {
            return -1;
        }

        // distance from target is 0.
        if (root == target) {
            distanceMap.put(root, 0);
            return 0;
        }

        int left = find(root.left, target, distanceMap);
        if (left >= 0) {
            distanceMap.put(root, left + 1);
            return left + 1;
        }

        int right = find(root.right, target, distanceMap);
        if (right >= 0) {
            distanceMap.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    // DFS
    private void dfs(TreeNode root, int k, Map<TreeNode, Integer> distanceMap, int length, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (distanceMap.containsKey(root)) {
            length = distanceMap.get(root);
        }
        if (length == k) {
            ans.add(root.val);
        }
        dfs(root.left, k, distanceMap, length + 1, ans);
        dfs(root.right, k, distanceMap, length + 1, ans);
    }

}

