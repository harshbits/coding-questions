package google.leetcode_2020.dp;

public class CoinChange2 {


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int ans = new CoinChange2().coinChange(coins, amount);
        System.out.println(ans);
    }


    public int coinChange(int[] coins, int amount) {

//        if (amount == 0) {
//            return 0;
//        }

        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, 1);
        dp[0] = 1;

        for (int coin : coins) {
//            for (int i = 1; i < amount + 1; i++) {
//                if(amount > coin){
//                    dp[i] = dp[i] + dp[amount - (coin + 1)];
//                }
//            }
            for (int i = coin; i < amount + 1; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
//            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }
}
