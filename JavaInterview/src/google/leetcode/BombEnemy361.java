package google.leetcode;

/**
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3 
Explanation: For the given grid,

0 E 0 0 
E 0 W E 
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.
 * 
 * @author hbhavsar
 *
 */
public class BombEnemy361 {
	
	private static final char WALL = 'W';

	private static final char ENEMY = 'E';

	private static final char EMPTY = '0';
	
	public static void main(String[] args) {
		BombEnemy361 b = new BombEnemy361();
		
		char[][] grid = {
				{'0', 'E', '0', '0'},
				{'E', '0', 'W', 'E'},
				{'0', 'E', '0', '0'}
		};
		int ans = b.maxKilledEnemies(grid);
		System.out.println(ans);
	}

	
	public int maxKilledEnemies(char[][] grid) {
		
		if(grid == null || grid.length == 0) {
			return 0;
		}

		int max = 0;
		int row = 0;
		
		// dp to store one killed enemies value for a row and an array of each column
		int[] column = new int[grid[0].length];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// for each position
				// if cell is empty
				// if(grid[i][j] == EMPTY) {
				// max = Math.max(max, maxDfsUtil(grid, i, j));
				//
				// }
				
				if(grid[i][j] == WALL) {
					continue;
				}
				
				if (j == 0 || grid[i][j - 1] == WALL) {
					row = killedEnemiesOnRow(grid, i, j);
				}
				
				if (i == 0 || grid[i - 1][j] == WALL) {
					column[j] = killedEnemiesOnCol(grid,i,j);
				}
				
				if (grid[i][j] == EMPTY) {
					max = (row + column[j]) > max ? (row + column[j]) : max;
				}
			}
		}
		
		return max;
	}
	
	
	private int killedEnemiesOnRow(char[][] grid, int i, int j) {
		int killed = 0;
		while ( j <= grid[0].length - 1 && grid[i][j] != WALL) {
			if (grid[i][j] == ENEMY) {
				killed++;
			}
			j++;
		}
		return killed;
	}
	
	private int killedEnemiesOnCol(char[][] grid, int i, int j) {
		int killed = 0;
		while (i <= grid.length - 1 && grid[i][j] != WALL) {
			if (grid[i][j] == ENEMY) {
				killed++;
			}
			i++;
		}
		return killed;
	}
	
	
	
	// we dont need DFS, as we just have to check row and column
	
//	private int maxDfsUtil(char[][] grid, int i, int j) {
//		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
//			return 0;
//		}
//		
//		int max = 0;
//
//		max = Math.max(max, maxDfsUtil(grid, i - 1, j));
//
//		max = Math.max(max, maxDfsUtil(grid, i + 1, j));
//
//		max = Math.max(max, maxDfsUtil(grid, i, j - 1));
//
//		max = Math.max(max, maxDfsUtil(grid, i, j + 1));
//		
//		return max;
//		
//	}
	
	
	
	
}
