package google.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 * @author hbhavsar
 *
 */
public class OptimalAccountBalancing465 {
	
	public static void main(String[] args) {
		OptimalAccountBalancing465 o = new OptimalAccountBalancing465();
		int[][] transactions = { 
				{ 0, 1, 10 }, 
				{ 1, 0, 1 }, 
				{ 1, 2, 5 }, 
				{ 2, 0, 5 } };
		int ans = o.minTransfers(transactions);
		System.out.println(ans);
	}
	
	public int minTransfers(int[][] transactions) {

		if (transactions == null || transactions.length == 0) {
			return 0;
		}
		Map<Integer, Integer> balanceMap = new HashMap<>();
		for (int[] t : transactions) {
			balanceMap.put(t[0], balanceMap.getOrDefault(t[0], 0) + t[2]);
			balanceMap.put(t[1], balanceMap.getOrDefault(t[1], 0) - t[2]);
		}
		// int[] debt = new int[balanceMap.keySet().size()];
		// int di = 0;
		// for (int value : balanceMap.values()) {
		// debt[di++] = value;
		// }

		int[] debt = balanceMap.values().stream().mapToInt(v -> v).toArray();
		int startIndex = 0;

		return dfsUtil(debt, startIndex);
	}
	
	
	private int dfsUtil(int[] nums, int index) {
		while (index < nums.length && nums[index] == 0) {
			index++;
		}
		if (index >= nums.length) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = index + 1; i < nums.length; i++) {
			long mul = (long) nums[i] * (long) nums[index];
			// if negative difference
			if (mul < 0) {
				nums[i] = nums[i] + nums[index];
				min = Math.min(min, dfsUtil(nums, i));
				// reassign the value
				nums[i] = nums[i] - nums[index];
			}
		}
		if (min == Integer.MAX_VALUE) {
			return 0;
		}

		return min + 1;
	}

}
