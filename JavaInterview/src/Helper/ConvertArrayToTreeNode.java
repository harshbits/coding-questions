package Helper;

public class ConvertArrayToTreeNode {

    public static void main(String args[]) {
        ConvertArrayToTreeNode c = new ConvertArrayToTreeNode();
        Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6};
        TreeNode root = c.arrayToTree(arr);
        c.inOrder(root);
        System.out.println();
        c.postOrder(root);
        System.out.println();
        c.preOrder(root);
    }

    public ConvertArrayToTreeNode() {
        super();
    }

    public static TreeNode arrayToTree(Integer[] arr) {
        return insertLevelOrder(arr, null, 0);
    }

    // Function to insert TreeNodes in level order 
    private static TreeNode insertLevelOrder(Integer[] arr, TreeNode root,
                                             int i) {
        // Base case for recursion 
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;
            // insert left child 
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child 
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }

    // Function to print tree TreeNodes in InOrder fashion 
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
