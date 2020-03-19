package google.leetcode_2020.matrix;

import java.util.Arrays;

public class CountSquareSubMatrices {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        int ans = new CountSquareSubMatrices().countSquares(matrix);
        System.out.println(ans);
    }


    public int countSquares(int[][] A) {
        int res = 0;
        int[][] dp = new int[A.length][A[0].length];
        int[] optimizedDp = new int[A[0].length];

        for (int i = 0; i < A.length; ++i) {
//            System.out.println(Arrays.deepToString(A));

            // This is previous element (i, j-1) element for current row
            int previous = 0;
            for (int j = 0; j < A[0].length; ++j) {
//                if (A[i][j] > 0 && i > 0 && j > 0) {
                if (A[i][j] > 0) {
                    //first roq
                    if (i == 0) {
                        optimizedDp[j] = A[i][j];
                    } else if (i > 0 && j > 0) {

//                        previous = dp[j-1]
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

//                        optimizedDp[j] =
                    }
                }
//                res += dp[i][j];
                res += optimizedDp[j];
            }
            System.out.println(i);
            System.out.println(Arrays.deepToString(dp));
        }
        return res;
    }

    public int countSquares1(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int dia = 0, pre = 0;
            for (int j = 0; j < n; j++) {
//                System.out.println(Arrays.toString(dp));
                // if 0 then do not count
                if (matrix[i][j] == 0) {
                    dia = dp[j];
                    pre = 0;
                    dp[j] = 0;
                } else {
                    int temp = dp[j];
                    int number = Math.min(dp[j], Math.min(dia, pre));
                    dp[j] = number + 1;
                    ans += dp[j];
                    pre = dp[j];
                    dia = temp;
                }
            }
        }

        return ans;
    }
}
