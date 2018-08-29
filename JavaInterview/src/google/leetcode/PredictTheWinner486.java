package google.leetcode;

public class PredictTheWinner486 {

	public static void main(String[] args) {
		PredictTheWinner486 p = new PredictTheWinner486();
		int[] nums = {1, 5, 2};
		boolean ans = p.PredictTheWinner(nums);
		System.out.println(ans);
	}

	public boolean PredictTheWinner(int[] nums) {
		
		if (nums.length == 1) {
			return true;
		}

		int n = nums.length;
		
//		int[][] dp = new int[n + 1][n];
//		
//		for (int i = n; i >= 0; i--) {
//			for (int j = i + 1; j < n; j++) {
//				dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//			}
//		}
//		return dp[0][n - 1] >= 0;
		int[] dp = new int[n];
		for (int i = n; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
			}
		}

		return dp[n - 1] >= 0;
	}
}
