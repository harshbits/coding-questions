package google.leetcode;

/**
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

 * @author hbhavsar
 *
 */
public class HouseRobber198 {
	
	
	public static void main(String[] args) {
		HouseRobber198 h = new HouseRobber198();
		int[] nums = { 1, 2, 3, 1 };
		int ans = h.rob(nums);
		System.out.println(ans);
	}

	public int rob(int[] nums) {
//		int inclusive = 0;
//		int exclusive = 0;
//
//		for (int n : nums) {
//			int temp = inclusive;
//			inclusive = Math.max(inclusive, exclusive + n);
//			exclusive = temp;
//		}
//		return inclusive;
		return rob(nums, 0, nums.length - 1);

	}
	
	public int rob(int[] nums, int start, int end) {
		int inclusive = 0;
		int exclusive = 0;
//		if (end < 0) {
//			end = 0;
//		}

		for (int i = start; i <= end; i++) {
			int n = nums[i];
			int temp = inclusive;
			inclusive = Math.max(inclusive, exclusive + n);
			exclusive = temp;
		}
		return inclusive;

	}

}
