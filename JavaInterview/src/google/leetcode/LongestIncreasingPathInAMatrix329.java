package google.leetcode;

/**
 * 
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * @author hbhavsar
 *
 */
public class LongestIncreasingPathInAMatrix329 {
	
	
	public static void main(String[] args) {
		LongestIncreasingPathInAMatrix329 l = new LongestIncreasingPathInAMatrix329();
		int[][] matrix = { 
				{ 9, 9, 4 }, 
				{ 6, 6, 8 }, 
				{ 2, 1, 1 } };
		int ans = l.longestIncreasingPath(matrix);
		System.out.println(ans);
	}

	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int max = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] memo = new int[m][n];

		// for each element
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// if current max is not 0 then.
				if (memo[i][j] == 0) {
					max = Math.max(max, dfsUtil(matrix, i, j, Integer.MIN_VALUE, memo));
				}
			}
		}

		return max;
	}

	private int dfsUtil(int[][] matrix, int i, int j, int previous, int[][] memo) {

		// most important condition to terminate recursion
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= previous) {
			return 0;
		}

		// if value any other than 0 which means it is already visited
		if (memo[i][j] != 0) {
			return memo[i][j];
		}

		int max = 0;
		int current = matrix[i][j];

		// top value
		max = Math.max(max, dfsUtil(matrix, i - 1, j, current, memo));

		// bottom value
		max = Math.max(max, dfsUtil(matrix, i + 1, j, current, memo));

		// left value
		max = Math.max(max, dfsUtil(matrix, i, j - 1, current, memo));

		// right value
		max = Math.max(max, dfsUtil(matrix, i, j + 1, current, memo));

		memo[i][j] = max + 1;

		return memo[i][j];
	}

}
