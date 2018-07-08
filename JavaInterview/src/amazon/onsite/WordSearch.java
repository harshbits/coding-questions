package amazon.onsite;

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
		
	}

	public boolean exist(char[][] board, String word) {

		char[] wordArray = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (exist(board, i, j, wordArray, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	private boolean exist(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length) {
			return true;
		}

		if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
			return false;
		}

		if (board[y][x] != word[i]) {
			return false;
		}

		board[y][x] ^= 256;
		boolean exist = exist(board, y, x + 1, word, i + 1) || 
				exist(board, y, x - 1, word, i + 1) || 
				exist(board, y + 1, x, word, i + 1) || 
				exist(board, y - 1, x, word, i + 1);
		board[y][x] ^= 256;
		return exist;
	}
}
