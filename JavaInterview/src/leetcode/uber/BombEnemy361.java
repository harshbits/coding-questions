package leetcode.uber;

public class BombEnemy361 {

	public static void main(String[] args) {

		char[][] grid = { { '0', 'E', '0', '0' }, { 'E', '0', 'W', 'E' }, { '0', 'E', '0', '0' } };
	}

	public int maxKilledEnemies(char[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int[] cols = new int[grid[0].length];
		
		for (int i = 0; i < grid.length; i++) {
			int count = 0;
			for (int j = 0; j < grid[0].length; j++) {

				// if it's wall count will be 0
				if (grid[i][j] == 'W') {
					count = 0;
					cols[j] = 0;
				}
				// if it's enemy, increase the  count
				else if (grid[i][j] == 'E') {
					count++;
					cols[j]++;
				}
				// if empty space
				else if (grid[i][j] == '0') {
					grid[i][j] = 0;
					grid[i][j] += count + cols[j];
				}
			}
		}
		
		return 0;
	}
	

	
}
