package amazon;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 * @author hbhavsar
 *
 */
public class WordSearch {
	
	public static void main(String[] args) {
		
		char[][] board = new char[3][4];
		board[0][0] = 'A';
		board[0][1] = 'B';
		board[0][2] = 'C';
		board[0][3] = 'E';
		
		board[1][0] = 'S';
		board[1][1] = 'F';
		board[1][2] = 'C';
		board[1][3] = 'S';
		
		board[2][0] = 'A';
		board[2][1] = 'D';
		board[2][2] = 'E';
		board[2][3] = 'E';
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 3; j++) {
//			}
//		}
		
//		System.out.println(board[0][1]);
//		board[0][1] ^= 256;
//		System.out.println(board[0][1]);
//		
//		board[0][1] ^= 256;
//		System.out.println(board[0][1]);
		
//		char a = (char) 'B' ^ 256;
//		System.out.println(a ^ 256);
		
//		String word = "ABCCED";
		String word = "ABCB";
		boolean answer = exist(board, word);
		System.out.println(answer);
		
	}
	
	
	public static boolean exist(char[][] board, String word) {

		int row = board.length;

		int col = board[0].length;

		// We can achieve without creating O(N) Extra space
//		boolean[][] visited = new boolean[row][col];
		
		// Time = O( row * col)
		// For each element of board, try to search pattern
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// Start with index 0
//				return dfsHelper(board, word, i, j, visited, 0);
				return dfsHelper(board, word, i, j, 0);
			}
		}
		return false;
	}
	
	
	// For adjacency matrix row * col,
	// Time = O (Row * Col) 
	public static boolean dfsHelper(char[][] board, String word, int row, int col, boolean[][] visited, int index) {
		
		// termination condition
		if (index == word.length()) {
			return true;
		}

		// Handle edge condition, whether can we move up and down or left and right or not
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			return false;
		}
		
		// Index of the word
		char ch = word.charAt(index);

		// if 1, if element is not visited
		// and 2, character is same as the element
		if (!visited[row][col] && board[row][col] == ch) {
			visited[row][col] = true;

			// All possible directions
			boolean result = dfsHelper(board, word, row + 1, col, visited, index + 1)
					|| dfsHelper(board, word, row - 1, col, visited, index + 1)
					|| dfsHelper(board, word, row, col + 1, visited, index + 1)
					|| dfsHelper(board, word, row, col - 1, visited, index + 1);
			
			// Mark element as unvisited
			visited[row][col] = false;
			
			return result;
		}
		return false;
	}
	
	
	
	private static boolean dfsHelper(char[][] board, String word, int row, int col, int index) {
		
		// termination condition
		if (index == word.length()) {
			return true;
		}

		// Handle edge condition, whether can we move up and down or left and right or not
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			return false;
		}
		
		// Index of the word
		char ch = word.charAt(index);

		// if 1, if element is not visited
		// and 2, character is same as the element
		if (board[row][col] == ch) {
			// Bitwise XOR = changed to some special character
			board[row][col] ^= 256;

			// All possible directions
			boolean result = dfsHelper(board, word, row + 1, col,  index + 1)
					|| dfsHelper(board, word, row - 1, col,  index + 1)
					|| dfsHelper(board, word, row, col + 1,  index + 1)
					|| dfsHelper(board, word, row, col - 1,  index + 1);
			
			// Bitwise XOR = From some special character to back to original number
			board[row][col] ^= 256;
			
			return result;
		}
		return false;
	}

}
