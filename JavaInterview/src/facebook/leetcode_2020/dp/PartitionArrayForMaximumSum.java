package facebook.leetcode_2020.dp;

public class PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        int[] A = {1, 15, 7, 9, 2, 5, 10};
        int K = 3;
        int ans = maxSumAfterPartitioning(A, K);
        System.out.println(ans);
    }

    // Time: O(nk)
    public static int maxSumAfterPartitioning(int[] A, int K) {

        int n = A.length;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; k++) {
//                if (i - k >= 0) {
//                }
                currentMax = Math.max(currentMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + currentMax * k);
            }
        }
        return dp[n - 1];
    }
}
