package leetcode.dp.med;

import java.util.Arrays;

public class MinimumPathSum64 {

	public static void main(String[] args) {

		int[][] grid = { 
				{ 1, 3, 1 }, 
				{ 1, 5, 1 }, 
				{ 4, 2, 1 } 
		};
		
		int ans = new MinimumPathSum64().minPathSum(grid);
		System.out.println(ans);
		
	}

	public int minPathSum(int[][] grid) {

		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		
		// for all rows and first column
		for (int i = 1; i < grid.length; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}
		
		// for all columns and first row
		for (int j = 1; j < grid[0].length; j++) {
			dp[0][j] = grid[0][j] + dp[0][j - 1];
		}
		
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		return dp[dp.length - 1][dp[0].length - 1];
	}

}

