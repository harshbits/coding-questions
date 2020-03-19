package google.leetcode_2020.dp;

public class CountIntegerPartitions {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new CountIntegerPartitions().numOfWays(n));
    }

    public int numOfWays(int n) {
//        int[][] dp = new int[n - 1][n + 1];

        int[] optimizedDp = new int[n + 1];
//
//        for (int i = 0; i < dp[0].length; i++) {
//            dp[0][i] = 1;
//        }
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = 1;
//        }

        // space o(n)
        for (int i = 0; i < optimizedDp.length; i++) {
            optimizedDp[i] = 1;
        }

//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 1; j < dp[0].length; j++) {
//                if (j > i) {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - (i + 1)];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }

//        return dp[dp.length - 1][dp[0].length - 1];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < optimizedDp.length; j++) {
                if (j > i) {
                    optimizedDp[j] = optimizedDp[j] + optimizedDp[j - (i + 1)];
                }
            }
        }

        return optimizedDp[optimizedDp.length - 1];
    }
}
