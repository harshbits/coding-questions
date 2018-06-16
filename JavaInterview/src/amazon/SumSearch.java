package amazon;

/**
 * Given a random MxN matrix and a positive integer, recursively Your program
 * should then find a continuous path thought the matrix starting at position
 * 0,0 that will sum to n. Your program should only move left (col -1),
 * right(col +1), up (row -1) and down (row+1)and can only use a position once
 * in the sum. if there is a such path in the matrix, create the path in a
 * separate matrix with the same size, and replacing the indices used with 1 and
 * the rest 0.
 * 
 * @author hbhavsar
 *
 */
public class SumSearch {

	public static void main(String[] args) {
		new SumSearch().helper();
	}

	public void helper() {

		// 1 2 3
		// 4 25 25
		// 5 25 25
		int[][] matrix = new int[3][3];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;

		matrix[1][0] = 4;
		matrix[1][1] = 25;
		matrix[1][2] = 25;

		matrix[2][0] = 5;
		matrix[2][1] = 25;
		matrix[2][2] = 25;

		// updatedPathMatrix(matrix, 10);
		// updatedPathMatrix(matrix, 35);
//		 updatedPathMatrix(matrix, 60);
		updatedPathMatrix(matrix, 85);

	}

	public void updatedPathMatrix(int[][] matrix, int total) {

		int row = matrix.length;

		int col = matrix[0].length;

		int[][] answer = new int[row][col];

		// Starting at position 0,0
		// if (dfsHelper(matrix, answer, total, 0, 0, 0)) {
		if (dfsHelper(matrix, answer, total, 0, 0)) {
			System.out.println("Answer is available");
		} else {
			System.out.println("Answer is NOT available");
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(answer[i][j] + "   ");
			}
			System.out.println();
		}
	}

	// public boolean dfsHelper(int[][] matrix, int[][] output, int sum, int
	// current, int r, int c) {
	public boolean dfsHelper(int[][] matrix, int[][] output, int sum, int r, int c) {
		output[r][c] = 1;
		if (sum - matrix[r][c] == 0) {
			return true;
		} else if (sum - matrix[r][c] < 0) {
			output[r][c] = 0;
			return false; 
		}
		boolean value = false;
		if (r + 1 < matrix.length && output[r + 1][c] != 1) {
//			if (dfsHelper(matrix, output, sum - matrix[r][c], r + 1, c)) {
//				return true;
//			} else {
//				output[r][c] = 0;
//				return false;
//			}
			value = value || dfsHelper(matrix, output, sum - matrix[r][c], r , c - 1);
		}
		if (r - 1 > -1 && output[r - 1][c] != 1) {
//			if (dfsHelper(matrix, output, sum - matrix[r][c], r - 1, c)) {
//				return true;
//			} else {
//				output[r][c] = 0;
//				return false;
//			}
			value = value || dfsHelper(matrix, output, sum - matrix[r][c], r, c + 1);
		}
		if (c - 1 > -1 && output[1][c - 1] != 1) {
//			if (dfsHelper(matrix, output, sum - matrix[r][c], r, c - 1)) {
//				return true;
//			} else {
//				output[r][c] = 0;
//				return false;
//			}
			value = value || dfsHelper(matrix, output, sum - matrix[r][c], r - 1, c);
		}
		if (c + 1 < matrix[0].length && output[r][c + 1] != 1) {
//			if (dfsHelper(matrix, output, sum - matrix[r][c], r, c + 1)) {
//				return true;
//			} else {
//				output[r][c] = 0;
//				return false;
//			}
			value = value || dfsHelper(matrix, output, sum - matrix[r][c], r + 1, c);
		}
		
		if(value) {
			return true;
		}
		
		output[r][c] = 0;
		return false;

		// if(sum == current) {
		//// output[r][c] = 1;
		// return true;
		// }
		// else if (sum - matrix[r][c] < 0) {
		// output[r][c] = 0;
		// return false;
		// }

		// Handle edge condition, whether can we move up and down or left and right or
		// not
		// if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length) {
		// output[r][c] = 0;
		// return false;
		// }
		//
		// if (output[r + 1][c] != 1) {
		// output[r][c] = 1;
		// current = current + matrix[r][c];
		// boolean found = dfsHelper(matrix, output, sum, current, r, c - 1)
		// || dfsHelper(matrix, output, sum, current, r, c + 1)
		// || dfsHelper(matrix, output, sum, current, r - 1, c)
		// || dfsHelper(matrix, output, sum, current, r + 1, c);
		// if (found) {
		// output[r][c] = 1;
		// return true;
		// } else {
		// output[r][c] = 0;
		// return false;
		// }
		// }
		//
		// output[r][c] = 0;
		// return false;
	}
}
