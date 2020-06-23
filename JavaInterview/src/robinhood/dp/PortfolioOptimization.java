package robinhood.dp;


import java.util.Arrays;

/**
 * You have some securities available to buy that each has a price Pi.
 * Your friend predicts for each security the stock price will be Si at some future date.
 * But based on volatility of each share, you only want to buy up to Ai shares of each security i.
 * Given M dollars to spend, calculate the maximum value you could potentially
 * achieve based on the predicted prices Si (and including any cash you have remaining).
 * <p>
 * Pi = Current Price
 * Si = Expected Future Price
 * Ai = Maximum units you are willing to purchase
 * M = Dollars available to invest
 */
public class PortfolioOptimization {

    public static void main(String[] args) {

        int[] P1 = {15, 40, 25, 30};
        int[] S1 = {45, 50, 35, 25};
        int[] A1 = {3, 3, 3, 4};
        int M1 = 140;

        int[] P2 = {15, 20};
        int[] S2 = {30, 45};
        int[] A2 = {3, 3};
        int M2 = 30;

        PortfolioOptimization p = new PortfolioOptimization();
        int ans = p.maxPortfolio(P1, S1, A1, M1);
        System.out.println(ans);

        int ans1 = p.maxPortfolio(P2, S2, A2, M2);
        System.out.println(ans1);

        double ans2 = p.maxPortfolioFraction(P1, S1, A1, M1);
        System.out.println(ans2);

        double ans3 = p.maxPortfolioFraction(P2, S2, A2, M2);
        System.out.println(ans3);
    }

    // Assumption- P, S and A are of same length.
    public int maxPortfolio(int[] P, int[] S, int[] A, int M) {
        int[][] dp = new int[P.length + 1][M + 1];
        for (int i = 0; i <= P.length; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                // Quantities of stocks
                for (int k = 0; k <= A[i - 1]; k++) {
                    if (j - k * P[i - 1] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * P[i - 1]] + k * S[i - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[P.length][M];
    }

    public double maxPortfolioFraction(int[] P, int[] S, int[] A, int M) {

        StockRatio[] stockRatios = new StockRatio[P.length];
        for (int i = 0; i < P.length; i++) {
            stockRatios[i] = new StockRatio(P[i], S[i], i);
        }

        //sorting items by value;
        Arrays.sort(stockRatios);

        double totalValue = 0d;

        for (StockRatio sr : stockRatios) {
            int currentPrice = (int) sr.currentPrice;
            int futurePrice = (int) sr.futurePrice;

            if (M - currentPrice >= 0) {
                M = M - currentPrice;
                totalValue += futurePrice;
            } else {
                // item cant be picked whole
                double fraction = ((double) M / (double) currentPrice);
                totalValue += (futurePrice * fraction);
//                M = (int) (M - (currentPrice * fraction));
                break;
            }
        }
        return totalValue;
    }

    // item value class
    private class StockRatio implements Comparable<StockRatio> {
        Double cost;
        double currentPrice;
        double futurePrice;
        int ind;

        // item value function
        public StockRatio(int currentPrice, int futurePrice, int ind) {
            this.currentPrice = currentPrice;
            this.futurePrice = futurePrice;
            this.ind = ind;
            cost = (double) futurePrice / currentPrice;
        }

        @Override
        public int compareTo(StockRatio o) {
            return o.cost.compareTo(this.cost);
        }
    }

}