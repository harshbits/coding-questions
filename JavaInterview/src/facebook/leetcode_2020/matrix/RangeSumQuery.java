package facebook.leetcode_2020.matrix;

public class RangeSumQuery {

    public static void main(String[] args) {
        new RangeSumQuery().test();
    }

    private void test() {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    // Time: O(mn) to prepare dp
    // Time: O(1) for sumRegion
    // Space: O(mn)
    class NumMatrix {

        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null
                    || matrix.length == 0
                    || matrix[0].length == 0) {
                return;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            this.dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // upper + left - prev. diagonal + current
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        // Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)
        public int sumRegion(int row1, int col1, int row2, int col2) {
//            int iMin = Math.min(row1, row2);
//            int iMax = Math.max(row1, row2);
//
//            int jMin = Math.min(col1, col2);
//            int jMax = Math.max(col1, col2);
//            return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];


            // dp(D) - dp(B) - dp(C) + dp(A)
            return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
        }
    }
}
