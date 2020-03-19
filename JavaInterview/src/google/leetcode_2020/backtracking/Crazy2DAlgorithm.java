package google.leetcode_2020.backtracking;

public class Crazy2DAlgorithm {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    //(9!)^9
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell

                            if (solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; //check row
            if (board[row][i] != '.' && board[row][i] == c) return false; //check column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
//
//    bool solve(int rows, int cols,
//               vector<int>&leftValues,
//               vector<int>&rightValues,
//               vector<int>&topValues,
//               vector<vector<int>>&solution) {
//        // check the left values
//        for (int r = 0; r < rows; ++r) {
//            if (leftValues[r] != std::numeric_limits < int>::min()){
//                // apply the left value in all columns (at the begin they are all free)
//                for (int c = 0; c < cols; ++c) {
//                    // set the value and mark the leftValue as used
//                    // a backup is needed to backtrack in case of failure
//                    solution[r][c] = leftValues[r];
//                    int backup = leftValues[r];
//                    leftValues[r] = std::numeric_limits < int>::min();
//                    // progress with the recurrence
//                    if (solve(rows, cols, leftValues, rightValues, topValues, solution))
//                        return true;
//                    // backtrack
//                    leftValues[r] = backup;
//                    solution[r][c] = std::numeric_limits < int>::min();
//                }
//            }
//        }
//
//        // check the top values
//        for (int c = 0; c < cols; ++c) {
//            if (topValues[c] != std::numeric_limits < int>::min()){
//                // apply the top value in all free rows
//                for (int r = 0; r < rows; ++r) {
//                    if (solution[r][c] == std::numeric_limits < int>::min())
//                    {
//                        solution[r][c] = topValues[c];
//                        int backup = topValues[c];
//                        topValues[c] = std::numeric_limits < int>::min();
//
//                        if (solve(rows, cols, leftValues, rightValues, topValues, solution))
//                            return true;
//
//                        topValues[c] = backup;
//                        solution[r][c] = std::numeric_limits < int>::min();
//                    }
//                }
//            }
//        }
//
//        // check the right values
//        for (int r = 0; r < rows; ++r) {
//            if (rightValues[r] != std::numeric_limits < int>::min()){
//                int availableCellIdx = -1;
//                int product = 1;
//                // loop to generate the product of current row, and to check if are some free
//                // spaces in the row
//                for (int c = 0; c < cols; ++c) {
//                    if (solution[r][c] != std::numeric_limits < int>::min())
//                    product *= solution[r][c];
//                else
//                    availableCellIdx = c;
//                }
//                // if the right value is not divisible by product we don't have solutions
//                if (rightValues[r] % product) {
//                    return false;
//                }
//                // if the right value is divisible by product but it is different from it
//                // and there are not spaces in the row, we don't have solutions
//                else if (rightValues[r] != product && availableCellIdx == -1) {
//                    return false;
//                }
//                // finally, if the right value is divisible by product but it is different
//                // and we have spaces we assign the proper value to match the constrain
//                else if (rightValues[r] != product) {
//                    int backup = rightValues[r];
//                    solution[r][availableCellIdx] = rightValues[r] / product;
//                    rightValues[r] = std::numeric_limits < int>::min();
//
//                    if (solve(rows, cols, leftValues, rightValues, topValues, solution))
//                        return true;
//
//                    rightValues[r] = backup;
//                    solution[r][availableCellIdx] = std::numeric_limits < int>::min();
//                }
//            }
//        }
//
//        return true;
//    }
}
