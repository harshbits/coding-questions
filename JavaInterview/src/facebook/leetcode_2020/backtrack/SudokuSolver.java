package facebook.leetcode_2020.backtrack;

public class SudokuSolver {


    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        doSolve(board, 0, 0);
    }

    private void doSolve(char[][] board, int row, int col) {

        for (int i = row; i < 9; i++, col = 0) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] == '.') {

                    for(char c = '1'; c <= '9'; c++){

                    }
                }
            }
        }
    }



}
