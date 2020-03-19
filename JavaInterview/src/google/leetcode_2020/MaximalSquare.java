package google.leetcode_2020;

import java.util.Arrays;

public class MaximalSquare {

    public static void main(String[] args) {
//        char[][] matrix = {{'1'}};

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int ans = new MaximalSquare().maximalSquare(matrix);
        System.out.println(ans);
    }


    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j] - '0';
                dp[i][j] = val;
                if (val > 0 && i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        // Optimized DP method
        // O(N) space = N = num of columns

        // Just keep track of previous row
        int[] optimizedDp = new int[matrix[0].length];
        int max1 = 0;
        for (int i = 0; i < matrix.length; i++) {
            // dp[i][j-1]
            int previousVal = 0;
            // dp[i-1][j-1]
            int diagonalVal = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int temp = optimizedDp[j];
                    optimizedDp[j] = Math.min(optimizedDp[j], Math.min(diagonalVal, previousVal)) + 1;
                    diagonalVal = temp;
                    previousVal = optimizedDp[j];

                } else {
                    diagonalVal = optimizedDp[j];
                    previousVal = 0;
                    optimizedDp[j] = 0;
                }
                max1 = Math.max(max1, optimizedDp[j]);
            }
        }

//        System.out.println(max1 * max1);
        return max * max;
    }
}

