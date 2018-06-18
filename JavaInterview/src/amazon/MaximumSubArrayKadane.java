package amazon;

/**
 * Date 07/31/2014
 * @author hbhavsar
 * 
 * Write a program to find maximum sum rectangle in give 2D matrix.
 * Assume there is at least one positive number in the 2D matrix.
 * 
 * Solution:
 * Keep temp array with size as number of rows. Start left and right from 0
 * and keep adding values for each row and maintain them in this temp array.
 * Run Kadane's algorithm to find max sum subarray in temp. Now increment right by
 * 1. When right reaches last column reset right to 1 and left to 1.
 * 
 * Space complexity of this algorithm is O(row)
 * Time complexity of this algorithm is O(row*col*col)
 * 
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 */
public class MaximumSubArrayKadane {
	
	public static void main(String[] args) {
		 int input[][] = {{ 2,  1, -3, -4,  5},
                 { 0,  6,  3,  4,  1},
                 { 2, -2, -1,  4, -5},
                 {-3,  3,  1,  0,  3}};
		System.out.println(new MaximumSubArrayKadane().maxSum(input));
	}
	
	
	int max = 0;
	int top = 0;
	int bottom = 0;
	int left = 0;
	int right = 0;
	
	private int maxSum(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		int[] kadaneComp = new int[row];
		
		// Iterating over columns will give horizontal boundaries
		for (int i = 0; i < col; i++) {
			// Clear the array, re initialize it every time
			for (int k = 0; k < row; k++) {
				kadaneComp[k] = 0;
			}

			for (int j = i + 1; j < col; j++) {
				for (int k = 0; k < row; k++) {
					kadaneComp[i] += matrix[k][j];
				}
//				int kadaneMax = kadane(kadaneComp);
//				if(kadaneMax > max) {
//					max = kadaneMax;
//					left = i;
//					right = j;
//				}
				modifiedKadane(kadaneComp, i, j);
			}
		}
		return max;
	}
	
	
	private void modifiedKadane(int[] array, int c1, int c2) {
		if (array == null || array.length == 0) {
			return;
		}

		int kadaneMax = 0;
		int currentSum = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		for (int i = 0; i < array.length; i++) {
			currentSum = Math.max(currentSum + array[i], array[i]);
			kadaneMax = Math.max(kadaneMax, currentSum);
			if (array[i] == max) {
				startIndex = i;
			} else if (max == currentSum) {
				endIndex = i;
			}
		}
		
		if (kadaneMax > max) {
			max = kadaneMax;
			left = c1;
			right = c2;
			top = startIndex;
			bottom = endIndex;
		}
	}
	
	
	// Kadane Algorithm.
	// This will give vertical boundary
	public int kadane(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int max = 0;
		int currentSum = 0;

		for (int i = 0; i < array.length; i++) {
			currentSum = Math.max(currentSum + array[i], array[i]);
			max = Math.max(max, currentSum);
			if (array[i] == max) {
				top = i;
			} else if (max == currentSum) {
				bottom = i;
			}
		}
		return max;
	}
	
	
	
 
}
