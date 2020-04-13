package facebook.leetcode_2020.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AntiDiagonalTraverse {

    public static void main(String[] args) {

        int[][] matrix = {
                {12, 7, 21, 31, 11},
                {45, -2, 14, 27, 19},
                {-3, 15, 36, 71, 26},
                {4, -13, 55, 34, 15}
        };

        var ans = new AntiDiagonalTraverse().diagonal(matrix);
        System.out.println(ans);

        ans = new AntiDiagonalTraverse().diagonal1(matrix);
        System.out.println(ans);
    }

    // Time: O(m * n)
    // Space: O(1)
    public List<List<Integer>> diagonal(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }
        int m = matrix.length;
        int n = matrix[0].length;

        List<List<Integer>> traversal = new ArrayList<>();

        for (int i = 0; i < m + n - 1; i++) {
            List<Integer> diagonal = new ArrayList<>();

            // determine row and column
            int row = i < n ? 0 : i - n + 1;
            int col = i < n ? i : n - 1;

            while (row < m && col >= 0) {
                diagonal.add(matrix[row][col]);
                row++;
                col--;
            }

            traversal.add(diagonal);
        }
        return traversal;
    }

    public List<List<Integer>> diagonal1(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int ind = i + j;

                if (result.size() <= ind) {
                    result.add(new ArrayList());
                }

                result.get(ind).add(matrix[i][j]);
            }
        }
        return result;
    }
}
