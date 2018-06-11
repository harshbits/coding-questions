package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * 
 * 
 * Example:
 * 
 * Input: 4 Output: [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ] Explanation: There exist two
 * distinct solutions to the 4-queens puzzle as shown above.
 * 
 * 
 * @author hbhavsar
 *
 */
public class NQueens {

	public static void main(String[] args) {

	}

	List<List<String>> result = new ArrayList<>();
	public List<List<String>> solveNQueens(int n) {

		boolean[] visited = new boolean[n];

		// 2 Diagonal arrays
		boolean[] diagonal1 = new boolean[2 * n - 1];
		// 2 Diagonal arrays
		boolean[] diagonal2 = new boolean[2 * n - 1];

		helper(n, visited, diagonal1, diagonal2, 0, new ArrayList<String>());
		return result;
	}

	// Recursion with backtracking
	private void helper(int n, boolean[] visited, boolean[] diagonal1, boolean[] diagonal2, int rowIndex,
			List<String> rowList) {
		
		if(rowIndex == n){
            result.add(new ArrayList<String>(rowList));
            return;
        }

		for (int i = 0; i < n; i++) {

			// If any of that true, stop the cycle.
			if (visited[i] || diagonal1[rowIndex + i] || diagonal2[rowIndex - i + n - 1]) {
				return;
			}

			// Initialize 1 dimensional array, for row
			char[] charArray = new char[n];
			Arrays.fill(charArray, '.');

			// Start by putting Queen at index i. (initially (0,0))
			charArray[i] = 'Q';

			String stringArray = new String(charArray);
			rowList.add(stringArray);

			// Mark visited true
			visited[i] = true;

			// it's diagonal value to true
			diagonal1[rowIndex + i] = true;

			// it's opposite diagonal value to true
			diagonal2[rowIndex - i + n - 1] = true;

			// move to next row.
			helper(n, visited, diagonal1, diagonal2, rowIndex + 1, rowList);

			// Does not affect the next goal of backtracking
			rowList.remove(rowList.size() - 1);

			charArray[i] = '.';
			visited[i] = false;
			diagonal1[rowIndex + i] = false;
			diagonal2[rowIndex - i + n - 1] = false;
		}
	}

}
