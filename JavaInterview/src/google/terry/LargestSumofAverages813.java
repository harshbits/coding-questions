package google.terry;

/**
 * 
 * We partition a row of numbers A into at most K adjacent (non-empty) groups,
 * then our score is the sum of the average of each group. What is the largest
 * score we can achieve?
 * 
 * Note that our partition must use every number in A, and that scores are not
 * necessarily integers.
 * 
 * Example: Input: A = [9,1,2,3,9] K = 3 Output: 20 Explanation: The best choice
 * is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3
 * + 9 = 20. We could have also partitioned A into [9, 1], [2], [3, 9], for
 * example. That partition would lead to a score of 5 + 2 + 6 = 13, which is
 * worse.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 100. 1 <= A[i] <= 10000. 1 <= K <= A.length. Answers within
 * 10^-6 of the correct answer will be accepted as correct.
 * 
 * @author hbhavsar
 *
 */
public class LargestSumofAverages813 {

	public static void main(String[] args) {
		LargestSumofAverages813 l = new LargestSumofAverages813();
		int[] A = {9,1,2,3,9};
		int K = 3;
		System.out.println(l.largestSumOfAverages(A, K));
	}

	public double largestSumOfAverages(int[] A, int K) {

		int n = A.length;
		// prefix sum
		double[] sum = new double[n + 1];
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + A[i];
		}

		// initially for just k = 1;
		double[] dp = new double[n];
		for (int i = 0; i < n; i++) {
			dp[i] = (sum[n] - sum[i]) /( n - i);
		}

		// all partitions
		// from K = 2 onwards
		for (int k = 0; k < K - 1; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					dp[i] = Math.max(dp[i], (sum[j] - sum[i]) / (j - i) + dp[j]);
				}
			}
		}

		return dp[0];
	}

}
