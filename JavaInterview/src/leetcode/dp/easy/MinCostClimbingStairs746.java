package leetcode.dp.easy;


/**
 * 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
 * 
 * @author habhavsar
 *
 */
public class MinCostClimbingStairs746 {

	
	public static void main(String[] args) {
		
		var cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		int ans = new MinCostClimbingStairs746().minCostClimbingStairs(cost);
		System.out.println(ans);
		ans = new MinCostClimbingStairs746().minCostClimbingStairsFWD(cost);
		System.out.println(ans);
	}
	
	public int minCostClimbingStairs(int[] cost) {

		if (cost == null || cost.length < 2) {
			return 0;
		}
		
//		int minCost = Math.min(cost[0], cost[1]);
//		int totalCost = minCost;
		
//		var finalCost1 = 0;
//		var finalCost2 = 0;
		
		int finalCost1 = 0;
		int finalCost2 = 0;

		// backward DP
		for (int i = cost.length - 1; i >= 0; --i) {
			
			int finalCost0 = cost[i] + Math.min(finalCost1, finalCost2);
			
			// move backward
			finalCost2 = finalCost1;
			finalCost1 = finalCost0;
			
		}
		
		return Math.min(finalCost1, finalCost2);
		
	}
	
	
	public int minCostClimbingStairsFWD(int[] cost) {

		if (cost == null || cost.length < 2) {
			return 0;
		}

//		int minCost = Math.min(cost[0], cost[1]);
//		int totalCost = minCost;

//		var finalCost1 = 0;
//		var finalCost2 = 0;

		int finalCost1 = cost[0];
		int finalCost2 = cost[1];

		// backward DP
		for (int i = 2; i < cost.length; i++) {

			int temp = finalCost2;
			finalCost2 = cost[i] + Math.min(finalCost1, finalCost2);

			// move forward
			finalCost1 = temp;

		}

		return Math.min(finalCost1, finalCost2);

	}

}
