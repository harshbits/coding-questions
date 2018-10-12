package leetcode.binarysearch;


/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 * 
 * 
 * @author Harsh Bhavsar
 *
 */
public class Search2DMatrixII240 {
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		
		boolean ans = new Search2DMatrixII240().searchMatrix(matrix, 5);
		
		System.out.println(ans);
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0) {
			return false;
		}

		int r = matrix.length;
		int c = matrix[0].length;

//		int mr = r / 2;
//		int mc = c / 2;

		int x = 0;
		int y = c - 1;

		while (x < r && y >= 0) {
			if (matrix[x][y] == target) {
				return true;
			}

			if (matrix[x][y] < target) {
				x++;
			} else if (matrix[x][y] > target) {
				y--;
			}
		}

		return false;
	}
}
