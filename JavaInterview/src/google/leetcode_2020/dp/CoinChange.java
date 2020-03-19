package google.leetcode_2020.dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;
//        int[] coins = {2};
//        int amount = 3;
        int ans = new CoinChange().coinChange(coins, amount);
        System.out.println(ans);
    }


    public int coinChange(int[] coins, int amount) {
//        int dp[] = new int[amount + 1];
//        // amount + 1 = max
//        Arrays.fill(dp, amount + 1);
//        // initial state is 0
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
////            int min = Integer.MAX_VALUE;
//            for (int coin : coins) {
//                if (coin <= i) {
//                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                }
//            }
//        }
//        if (dp[amount] > amount) {
//            return -1;
//        }
//        return dp[amount];

        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // to prevent overflow in Math.min function
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
            System.out.println(Arrays.toString(dp));
        }
        if (dp[amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return dp[amount];
    }
}
