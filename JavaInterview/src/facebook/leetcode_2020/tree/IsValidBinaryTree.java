package facebook.leetcode_2020.tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsValidBinaryTree {

    public static void main(String[] args) {
        IsValidBinaryTree is = new IsValidBinaryTree();
        is.basicTest1();
    }


    public void basicTest1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        var ans = isBinaryTree(Arrays.asList(n4, n2, n3, n1));
        System.out.println(ans);
    }

    //Time: O(N)
    //Space: O(N)
    public boolean isBinaryTree(List<TreeNode> nodes) {
        Set<TreeNode> roots = new HashSet<>();
        Set<TreeNode> seen = new HashSet<>();

        for (TreeNode cur : nodes) {
            if (seen.contains(cur)) {
                continue;
            }
            Set<TreeNode> curSeen = new HashSet<>();
            if (hasCycle(cur, roots, curSeen)) {
                return false;
            }
            seen.addAll(curSeen);
            roots.add(cur);
        }
        // Tree can only have 1 root
        // Seen size shold be same as actual nodes.
        return roots.size() == 1 && seen.size() == nodes.size();
    }

    private boolean hasCycle(TreeNode cur, Set<TreeNode> roots, Set<TreeNode> curSeen) {
        if (cur == null) return false;
        if (curSeen.contains(cur)) return true;
        curSeen.add(cur);
        roots.remove(cur);
        return hasCycle(cur.left, roots, curSeen) || hasCycle(cur.right, roots, curSeen);
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
