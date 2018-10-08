package leetcode.dp.easy;

/**
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * @author habhavsar
 *
 */
public class MaximumSubarray53 {

	
	public static void main(String[] args) {
//		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] nums = { -1 };
		int ans = new MaximumSubarray53().maxSubArray(nums);
		System.out.println(ans);
	}

	public int maxSubArray(int[] nums) {

		int current = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			current += nums[i];
			if (max < current) {
				max = current;
			}
//			if(current < nums[i]) {
//				current = nums[i];
//			}
			if(current < 0) {
				current = 0;
			}
			
//			current = Math.max(current + nums[i], nums[i]);
//			max = Math.max(current, max);
		}
		return max;
	}

}
