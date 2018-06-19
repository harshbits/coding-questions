package amazon;

/**
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 * 
 * @author hbhavsar
 *
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = { {'1', '1', '0', '0', '0'},
						{'1', '1', '0', '0', '0'},
						{'0', '0', '1', '0', '0'},
						{'0', '0', '0', '1', '1'} };
		int ans = new NumberOfIslands().numIslands(grid);
		System.out.println(ans);
	}
	
	
	public int numIslands(char[][] grid) {
		// edge scenarios
//		if (grid == null || grid.length == 0) {
//			return 0;
//		}
		
		int totalIslands = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				totalIslands += dfsHelper(grid, i, j);
			}
		}
		
		return totalIslands;
	}
	
	/**
	 * DFS helper method. 
	 * It will terminate once there wont be any adjacent node with value "1"
	 * 
	 * @param grid
	 * @param i represents row
	 * @param j represents column
	 * 
	 * @return
	 */
	private int dfsHelper(char[][] grid, int i, int j) {
		
		// Base condition//
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return 0;
		}
		
		// mark the node value as 0, meaning we wont be visiting that node.
		grid[i][j] = '0';

		// Move in all directions, till island is sunk in water ('0')

		// top
		dfsHelper(grid, i - 1, j);

		// bottom
		dfsHelper(grid, i + 1, j);

		// right
		dfsHelper(grid, i, j + 1);

		// left
		dfsHelper(grid, i, j - 1);

		return 1;
	}
	
	
}
