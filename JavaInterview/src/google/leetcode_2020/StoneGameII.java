package google.leetcode_2020;

import java.util.Arrays;


public class StoneGameII {

    public static void main(String[] args) {

        int[] piles = {2, 7, 9, 4, 4};
        int ans = new StoneGameII().stoneGameII(piles);
        System.out.println(ans);
    }

    // Mini MAX algorithm
    public int stoneGameII(int[] piles) {

        // bottom up dp
        for (int i = 1; i < piles.length; i++) {
            piles[i] += piles[i - 1];
        }
        // init variables
        int M = 1;
        int i = 0;
        // 0 or 1
        int player = 0;

        //dp[k][i][j]: the max total stones for player k to take from piles[i:len) given M == j
        int[][][] dp = new int[2][piles.length][piles.length + 1];

        return dfs(player, M, i, piles, dp);
    }


    private int dfs(int player, int M, int i, int[] piles, int[][][] dp) {
        // termination
        if (i >= piles.length) {
            return 0;
        }


        if (dp[player][i][M] != 0) {
            return dp[player][i][M];
        }

        int max = -1;
        // Sum till previous index
        int preSum = i - 1 < 0 ? 0 : piles[i - 1];

        // Another termination condition
        // If another player can collect all the stones then do it.
        if (i + 2 * M >= piles.length) {
            dp[player][i][M] = piles[piles.length - 1] - preSum;
            return piles[piles.length - 1] - preSum;
        }

        for (int k = 1; k <= 2 * M; k++) {
            // opponent = 1.
            int opponent = dfs(1 - player, Math.max(M, k), i + k, piles, dp);
            int current = piles[piles.length - 1] - preSum - opponent;
            max = Math.max(max, current);
        }
        dp[player][i][M] = max;
        return max;
    }



    //
/*
final int n = piles.length;
for (int i = n - 2; i >= 0; i--) piles[i] += piles[i+1];
if (n <= 2) return piles[0];
int[][] dp = new int[n][(n+1)/2+1];
for (int i = n-1; i >= 0; i--) {
        int sum = piles[i];
        int m = (n-i+1)/2;
        dp[i][m] = sum;
        while (--m > 0) {
            dp[i][m] = 0;
            for (int x = 1; x <= m * 2 && i+x < n; x++) {
                int mx = Math.min((n-i-x+1)/2, Math.max(x, m));
                dp[i][m] = Math.max(dp[i][m], sum - dp[i+x][mx]);
            }
        }
    }
return dp[0][1];

*/


}
