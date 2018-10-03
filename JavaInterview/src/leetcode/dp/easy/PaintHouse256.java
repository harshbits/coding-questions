package leetcode.dp.easy;

/**
 * 
 * 
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
             Minimum cost: 2 + 5 + 3 = 10.
 * @author habhavsar
 *
 */
public class PaintHouse256 {
	
	
	public static void main(String[] args) {
		
		int[][] paintcost = { { 7, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		
		int ans = new PaintHouse256().minCost(paintcost);
		System.out.println(ans);
	}

	public int minCost(int[][] costs) {
		
		if (costs == null || costs.length == 0 || costs[0].length != 3) {
			return 0;
		}

		int dp[] = new int[3];
		for (int[] cost : costs) {
			// temp dp
			// in order to save space
			// constant space
			int[] next = new int[3];
			next[0] = Math.min(dp[1], dp[2]) + cost[0];
			next[1] = Math.min(dp[0], dp[2]) + cost[1];
			next[2] = Math.min(dp[0], dp[1]) + cost[2];
			dp = next;
		}
		
		return Math.min(dp[0], Math.min(dp[1], dp[2]));
	}
}
