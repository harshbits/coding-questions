package google.leetcode_2020.matrix;

public class LargestIncreasingPathInMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        int ans = new LargestIncreasingPathInMatrix().longestIncreasingPath(matrix);
        System.out.println(ans);
    }

    //
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfsHelper(matrix, dp, i, j));
//                dp[i][j] = max;
            }
        }
        return max;
    }

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int dfsHelper(int[][] matrix, int[][] dp, int i, int j) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

//        int max = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dfsHelper(matrix, dp, x, y));
            }
        }
//        return max++;
        return ++dp[i][j];
    }
}
