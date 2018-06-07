package amazon;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * 
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
 * not burst them. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 Example:
 * 
 * Input: [3,1,5,8] Output: 167 Explanation: nums = [3,1,5,8] --> [3,5,8] -->
 * [3,8] --> [8] --> [] coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * 
 * 
 * 
 * https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
 * 
 * @author hbhavsar
 *
 */
public class BurstBalloons {

	public static void main(String[] args) {

		int[] nums = { 3, 1, 5, 8 };

		int maxCoins = maxCoinsUsingDP(nums);

//		int maxCoins = new BurstBalloons().maxCoinsUsingRecurrsionMemoization(nums);

		System.out.println(maxCoins);
	}

	public static int maxCoins(int[] nums) {

		return 0;
	}

	public static int maxCoinsUsingDP(int[] input) {

		// We can remove this array, instead initialize first and last as alwasy 1.
		int[] nums = new int[input.length + 2];
		int n = 1;
		for (int x : input) {
			if (x > 0) {
				nums[n++] = x;
			}
		}
		nums[0] = nums[n++] = 1;

		// SPACE = O(n^2)
		int[][] dp = new int[n][n];
		
		// TIME = O(n^3)
		for (int k = 2; k < n; ++k) {
			for (int left = 0; left < n - k; ++left) {
				int right = left + k;
				for (int i = left + 1; i < right; ++i) {
					dp[left][right] = Math.max(dp[left][right],
							nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
				}

			}
		}
		return dp[0][n - 1];
	}

	public int maxCoinsUsingRecurrsionMemoization(int[] input) {

		int[] nums = new int[input.length + 2];
		int n = 1;
		for (int x : input) {
			if (x > 0) {
				nums[n++] = x;
			}
		}
		nums[0] = nums[n++] = 1;

		int[][] memo = new int[n][n];

		return burst(memo, nums, 0, n - 1);
	}

	public int burst(int[][] memo, int[] nums, int left, int right) {
		System.out.println(left + " " + right);

		System.out.println(memo[left][right]);
		if (left + 1 == right) {
			return 0;
		}

		if (memo[left][right] > 0) {
			return memo[left][right];
		}
		int ans = 0;
		for (int i = left + 1; i < right; ++i) {
			ans = Math.max(ans,
					nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i) + burst(memo, nums, i, right));
		}
		memo[left][right] = ans;
		return ans;
	}

}
