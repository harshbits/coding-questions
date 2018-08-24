package google.leetcode;

/**
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.

 * 
 * @author hbhavsar
 *
 */
public class RangeSumQuery2DMutable308 {

	int matrix[][];
	int BIT[][];
	int m;
	int n;

	public static void main(String[] args) {

		int[][] matrix = { 
				{ 3, 0, 1, 4, 2 }, 
				{ 5, 6, 3, 2, 1 }, 
				{ 1, 2, 0, 1, 5 }, 
				{ 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		RangeSumQuery2DMutable308 r = new RangeSumQuery2DMutable308(matrix);
		int sum = r.sumRegion(2, 1, 4, 3);
		System.out.println(sum);
		r.update(3, 2, 2);
		sum = r.sumRegion(2, 1, 4, 3);
		System.out.println(sum);
	}

	public RangeSumQuery2DMutable308(int[][] matrix) {
		this.m = matrix.length;
		this.n = matrix[0].length;
		// this.matrix = matrix;
		// initialize it as empty;
		this.matrix = new int[m][n];
		this.BIT = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				update(i, j, matrix[i][j]);
			}
		}
	}

	public void update(int row, int col, int val) {

		int diff = val - matrix[row][col];
		matrix[row][col] = val;

		for (int i = row + 1; i <= m;) {
			for (int j = col + 1; j <= n;) {
				BIT[i][j] += diff;
				j += (j & -j);
			}
			i += (i & -i);
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
	}

	private int sum(int row, int col) {
		int sum = 0;

		for (int i = row; i > 0;) {
			for (int j = col; j > 0;) {
				sum += BIT[i][j];
				j -= (j & -j);
			}
			i -= (i & -i);
		}
		return sum;
	}
}
