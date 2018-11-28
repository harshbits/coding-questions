package leetcode.uber;

import java.util.HashSet;
import java.util.Set;

public class ValidSudokui36 {

	public static void main(String[] args) {

	}

	public boolean isValidSudoku(char[][] board) {
//		List<Character> x = new ArrayList<>();
//		List<Character> y = new ArrayList<>();
		
		Set<Character> x = new HashSet<>();
		Set<Character> y = new HashSet<>();
		
		// for each row and column, one by one
		// clear the set once we finish one row and column
		for (int i = 0; i < 9; i++, x.clear(), y.clear()) {
			for (int j = 0; j < 9; j++) {

				// for all row values
				if (board[i][j] != '.')
					if (x.contains(board[i][j]))
						return false;
					else
						x.add(board[i][j]);

				// for all column values
				if (board[j][i] != '.')
					if (y.contains(board[j][i]))
						return false;
					else
						y.add(board[j][i]);
			}
		}
		// for smaller 3 * 3 boxes
		for (int i = 0; i < 7; i += 3)
			for (int j = 0; j < 7; j += 3, x.clear())
				for (int k = 0; k < 3; k++)
					for (int t = 0; t < 3; t++)
						if (board[i + k][j + t] != '.')
							if (x.contains(board[i + k][j + t]))
								return false;
							else
								x.add(board[i + k][j + t]);
		return true;
	}
}
