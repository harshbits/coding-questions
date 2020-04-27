package facebook.leetcode_2020.array;

public class PartitionArrayMaxSum {

    public static void main(String[] args) {
        int[] A = {1, 15, 7, 9, 2, 5, 10};
        System.out.println(new PartitionArrayMaxSum().maxSumAfterPartitioning(A, 3));
    }

    // Time O(NK)
    // Space O(N)

    // dp[i] record the maximum sum we can get considering A[0] ~ A[i]
    // To get dp[i], we will try to change k last numbers separately to the maximum of them,
    // where k = 1 to k = K.
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; k++) {
                currentMax = Math.max(currentMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + currentMax * k);
            }
        }
        return dp[n - 1];
    }
}

