package google.leetcode;

/**
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * Input: [2,3,2] Output: 3 Explanation: You cannot rob house 1 (money = 2) and
 * then rob house 3 (money = 2), because they are adjacent houses. Example 2:
 * 
 * Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then rob
 * house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * 
 * @author hbhavsar
 *
 */
public class HouseRobberII213 {

	public static void main(String[] args) {
		HouseRobberII213 h = new HouseRobberII213();
		// int[] nums = { 2, 3, 2 };
		// int[] nums = { 1, 2, 3, 1 };
		int[] nums = { 1 };
		int ans = h.rob(nums);
		System.out.println(ans);

	}

	public int rob(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		HouseRobber198 h = new HouseRobber198();

		int sum1 = h.rob(nums, 0, nums.length - 2);

		int sum2 = h.rob(nums, 1, nums.length - 1);

		return Math.max(sum1, sum2);
	}

}
