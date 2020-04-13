package facebook.leetcode_2020.slidingwindow;

public class FruitInTheBaskets {

    public static void main(String[] args) {
        int[] tree = {0, 1, 2, 2};
        int ans = new FruitInTheBaskets().totalFruit(tree);
//        System.out.println(ans);


    }


    public int totalFruit(int[] tree) {
        if (tree.length <= 2) {
            return tree.length;
        }

        int n = tree.length;
        int i = 0;
        int j = 1;

        while (j < n && tree[j] == tree[i]) {
            j++;
        }
        if (j >= n) {
            return n;
        }

        // c1, c2  are types of different tree
        int c1 = tree[i];
        int c2 = tree[j];
        int max = 2;

        while (i < n && j < n) {
            while (j < n && (tree[j] == c1 || tree[j] == c2)) {
                j++;
            }

            max = Math.max(max, j - i);
            if (j >= n) {
                break;
            }

            c1 = tree[j - 1];
            c2 = tree[j];

            // determine the i, until all i elements are same
            while (i >= 0 && tree[i] == tree[j - 1]) {
                i--;
            }
            i++;
        }
        return max;
    }
}
