package leetcode.dfs;

import java.util.List;

/**
 * 
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 10 
Explanation: Four 1's at depth 2, one 2 at depth 1.
Example 2:

Input: [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.

 * 
 * @author habhavsar
 *
 */
public class NestedListWeightSumII364 {
	
	

	public int depthSumInverse(List<NestedInteger> nestedList) {
		
		// values[0] => holds the max depth
		// values[1] => holds the flat sum, without weight
		int[] values = new int[2];
		
		// this will do sum in following format
		// 1x + 2y + 3z + ...
		int depthSum = depthSum(nestedList, values, 1);
		
		
		// convert it to 3x + 2y + 1z 
		// formula
		// 3x + 2y + 1z = (3 + 1) * (x + y + z) - 1x + 2y + 3z
		
		int depthSumInverse = (values[0] + 1) * values[1] - depthSum;

		return depthSumInverse;
	}

	public int depthSum(List<NestedInteger> nestedList, int[] values, int depth) {

		int sum = 0;

		for (NestedInteger n : nestedList) {
			if (n.isInteger()) {
				sum += n.getInteger() * depth;
				values[0] = Math.max(values[0], depth);
				values[1] += n.getInteger();
			} else {
				sum += depthSum(n.getList(), values, depth + 1);
			}
		}
		return sum;

	}

}
