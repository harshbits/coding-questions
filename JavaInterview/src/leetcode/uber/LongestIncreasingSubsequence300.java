package leetcode.uber;

import java.util.Arrays;

/**
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

 * @author habhavsar
 *
 */
public class LongestIncreasingSubsequence300 {

	public static void main(String[] args) {

		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		long start = System.currentTimeMillis();
		var ans = new LongestIncreasingSubsequence300().longestIncreasingSubseqDP(nums);
		long end = System.currentTimeMillis();
		System.out.println("TIME: " + (end - start) + ", ANS: " + ans);

		start = System.currentTimeMillis();
		ans = new LongestIncreasingSubsequence300().longestIncreasingSubseqBS(nums);
		end = System.currentTimeMillis();
		System.out.println("TIME: " + (end - start) + ", ANS: " + ans);
	}

	// Using BInary Search and DP
	// O(N) Space, O( N log N) Time
	public int longestIncreasingSubseqBS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		int length = 0;
		
		for (int n : nums) {
			int low = 0;
			int high = length;
			
			while (low < high) {
				int mid = (low + high) / 2;
				if (dp[mid] <= n) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			dp[low] = n;
			if(low == length) {
				length++;
			}
		}

		return length;
	}

	// Using DP, 2 pointers
	// O(N) Space, O( N ^ 2) Time
	public int longestIncreasingSubseqDP(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// Initialize array with 1
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {

				if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		// Maximum from DP
		return Arrays.stream(dp).max().getAsInt();
	}

}
