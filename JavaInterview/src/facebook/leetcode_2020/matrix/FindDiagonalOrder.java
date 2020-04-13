package facebook.leetcode_2020.matrix;

import java.util.Arrays;

public class FindDiagonalOrder {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] order = new FindDiagonalOrder().findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(order));
    }

    // If out of bottom border (row >= m) then row = m - 1; col += 2; change walk direction.
    // if out of right border (col >= n) then col = n - 1; row += 2; change walk direction.
    // if out of top border (row < 0) then row = 0; change walk direction.
    // if out of left border (col < 0) then col = 0; change walk direction.

    // Time: O(m * n)
    // Space: O(1)
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] order = new int[m * n];
        if (m == 0 || n == 0) {
            return order;
        }

        int row = 0;
        int col = 0;
        int direction = 1;

        for (int i = 0; i < m * n; i++) {
            order[i] = matrix[row][col];

            row -= direction;
            col += direction;

            // bottom boundary
            if (row >= m) {
                row = m - 1;
                col += 2;
                direction = -direction;
            }

            // right boundary
            if (col >= n) {
                row += 2;
                col = n - 1;
                direction = -direction;
            }

            // top boundary
            if (row < 0) {
                row = 0;
                direction = -direction;
            }

            // left boundary
            if (col < 0) {
                col = 0;
                direction = -direction;
            }
        }
        return order;
    }
}
