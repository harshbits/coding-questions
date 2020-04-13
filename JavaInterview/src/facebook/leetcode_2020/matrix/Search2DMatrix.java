package facebook.leetcode_2020.matrix;

public class Search2DMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        boolean ans = new Search2DMatrix().searchMatrix(matrix, 5);
        System.out.println(ans); // true

        ans = new Search2DMatrix().searchMatrix(matrix, 99);
        System.out.println(ans); // false

        ans = new Search2DMatrix().searchMatrix(matrix, 23);
        System.out.println(ans); // true
    }

    // Time: O(r + c)
    // space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0, c = cols - 1;
        while (c >= 0 && r < rows) {

            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
