package google.leetcode_2020.dp;

import java.util.Arrays;

public class CardGame {

    public static void main(String[] args) {
        CardGame c = new CardGame();
        int ar[] = {1, 1, 1, 1, 100};
//        int val = c.cardGame(ar);
//        System.out.println(val); // 101

        int ar1[] = {1, 2, -3, 8};
        int val1 = c.cardGame(ar1);
        System.out.println(val1); // 3
    }


    public int cardGame(int[] cards) {

        int dp[] = new int[cards.length];
        int[] sum = new int[cards.length];

        // sum from last element
        for (int i = cards.length - 1; i >= 0; i--) {
            sum[i] += (i == cards.length - 1) ? cards[i] : sum[i + 1] + cards[i];
        }
//        System.out.println(Arrays.toString(sum));
        for (int i = cards.length - 1; i >= 0; i--) {

            // if player take one card
            int one = (i < cards.length - 1) ? (sum[i + 1] - dp[i + 1] + cards[i]) : cards[i];

            // if player take two cards
            int two = (i < cards.length - 2) ? (sum[i + 2] - dp[i + 2] + cards[i] + cards[i + 1]) :
                    (i < cards.length - 1) ? cards[i] + cards[i + 1] : Integer.MIN_VALUE;

            // if player take three cards
            int three = (i < cards.length - 3) ? (sum[i + 3] - dp[i + 3] + cards[i] + cards[i + 1] + cards[i + 2]) :
                    (i < cards.length - 2) ? cards[i] + cards[i + 1] + cards[i + 2] : Integer.MIN_VALUE;


            System.out.println("One " + one + ", Two " + two + ", Three " + three);

            dp[i] = Math.max(Math.max(one, two), three);

            System.out.println(Arrays.toString(dp));
        }

        return dp[0];

    }
}
