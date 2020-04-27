package facebook.leetcode_2020.tree;

public class StringFromBinaryTree {

    public static void main(String[] args) {
        new StringFromBinaryTree().test();
    }

    private void test() {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);

        String ans = tree2str(t);
        System.out.println(ans);
    }

    public String tree2str(TreeNode t) {
        // corner case
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        DFS(t, sb);
        return sb.toString();
    }

    private void DFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(")");
            return;
        }

        sb.append(node.val);

        if (node.left != null || node.right != null) {
            // every time we go to one branch, we add (
            sb.append("(");
            DFS(node.left, sb);
            sb.append(")");
            // close the branch

            // If both of them are null then only need one bracket pair
            if (node.right != null) {
                sb.append("(");
                DFS(node.right, sb);
                sb.append(")");
            }
        }
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
