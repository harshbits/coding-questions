package google.leetcode_2020.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StoneGameII {

    public static void main(String[] args) {

        int[] piles = {2, 7, 9, 4, 4};
        int ans = new StoneGameII().stoneGameII(piles);
        System.out.println(ans);
    }


    public int stoneGameII(int[] piles) {

        // bottom up dp
        for (int i = 1; i < piles.length; i++) {
            piles[i] += piles[i - 1];
        }

        System.out.println(Arrays.toString(piles));

        // init variables
        int M = 1;
        int i = 0;
        // 0 or 1
        int player = 0;
//        Map<String, Integer> memo = new HashMap<>();

        //dp[k][i][j]: the max total stones for player k to take from piles[i:len) given M == j
        int[][][] dp = new int[2][piles.length][piles.length + 1];

        return dfs(player, M, i, piles, dp);
    }


    //    private int dfs(int M, int i, int[] piles, Map<String, Integer> memo) {
    private int dfs(int player, int M, int i, int[] piles, int[][][] dp) {
        // termination
        if (i >= piles.length) {
            return 0;
        }
//        String dfsKey = M + "," + i;
//        if (memo.containsKey(dfsKey)) {
//            return memo.get(dfsKey);
//        }

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
//            int opponent = dfs(Math.max(M, k), i + k, piles, memo);
            // opponent = 1.
            int opponent = dfs(1 - player, Math.max(M, k), i + k, piles, dp);
            int current = piles[piles.length - 1] - preSum - opponent;
            max = Math.max(max, current);
        }
//        memo.put(dfsKey, max);
        dp[player][i][M] = max;
        return max;
    }
}
