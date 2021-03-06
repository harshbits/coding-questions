package google.leetcode;

/**
 * 
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], 
 * Output: 6 
 * Explanation: [4,-1,2,1] has the
 * largest sum = 6. 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 * 
 * @author hbhavsar
 *
 */
public class MaximumSubarray53 {
	
	public static void main(String[] args) {
		MaximumSubarray53 m = new MaximumSubarray53();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int ans = m.maxSubArray(nums);
		System.out.println(ans);
		
		ans = m.maxSubArrayConstant(nums);
		System.out.println(ans);
	}
	
	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
		dp[0] = nums[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
	
	
	public int maxSubArrayConstant(int [] nums) {
		int n = nums.length;
		int max = nums[0];
		int currentMax = nums[0];
		
		for (int i = 1; i < n; i++) {
			// abhi tak ka max plus current number
			// and current number. jo bada ho vo
			currentMax = Math.max(currentMax + nums[i], nums[i]);
			// if current max greater than max, to new max
			max = Math.max(currentMax, max);
		}
		return max;
	}

}
