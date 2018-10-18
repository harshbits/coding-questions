package leetcode.dfs;

public class MaxAreaOfIsland {
	
	
	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		
		int ans = new MaxAreaOfIsland().maxAreaOfIsland(grid);
		System.out.println(ans);
	}

	
	public int maxAreaOfIsland(int[][] grid) {

		int max = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
			
				if (grid[i][j] != 0) {
//					System.out.println("i: " + i + " -> j: " + j);
					max = Math.max(max, maxAreaDfs(grid, i, j));
				}
			}
		}
		
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//
//				if (grid[i][j] == -1) {
//					grid[i][j] = 1;
//				}
//			}
//		}

		return max;
	}
	
	public int maxAreaDfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = -1;
		return 1 + maxAreaDfs(grid, i + 1, j) + maxAreaDfs(grid, i - 1, j) + maxAreaDfs(grid, i, j + 1)
				+ maxAreaDfs(grid, i, j - 1);
	}
}
