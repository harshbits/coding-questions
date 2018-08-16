package google.leetcode;

/**
 * 
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.

 

Example 1:

Input: grid = 
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 

Example 2:

Input: grid = 
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 

Example 3:

Input: grid = 
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.
 

Note:

The number of rows and columns of grid will each be in the range [1, 200].
Each grid[i][j] will be either 0 or 1.
The number of 1s in the grid will be at most 6000.

 * @author hbhavsar
 *
 */
public class NumberOfCornerRectangles750 {

	
	
	public static void main(String[] args) {
		
//		int[][] grid = {
//				 {1, 0, 0, 1, 0},
//				 {0, 0, 1, 0, 1},
//				 {0, 0, 0, 1, 0},
//				 {1, 0, 1, 0, 1}};
		
		int[][] grid = {
				 {1, 1, 1},
				 {1, 1, 1},
				 {1, 1, 1}};
		
		NumberOfCornerRectangles750 n = new NumberOfCornerRectangles750();
		int ans = n.countCornerRectangles(grid);
		System.out.println(ans);
		
	}
	public int countCornerRectangles(int[][] grid) {
		
		
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				
//				int counter = 0;
//				if(grid[i][j] == 1) {
//					
//					// Look for 1
//					for(int k = 0; k < grid.length ; k++) {
//					}	
//				}
//			}
//		}
		int answer = 0;
		// ROW
		for (int i = 0; i < grid.length - 1; i++) {
			// Each row after ROW
			for (int j = i + 1; j < grid.length; j++) {
				int counter = 0;
				// For each column for ROW combination
				for (int k = 0; k < grid[0].length; k++) {

					if (grid[i][k] == 1 && grid[j][k] == 1) {
						counter++;
					}
				}
				if (counter > 0) {
					answer += counter * (counter - 1) / 2;
				}
			}
		}
		return answer;
	}
	
}
