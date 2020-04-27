package facebook.leetcode_2020.backtrack;

public class WordSearch {

    public static void main(String[] args) {

        char board[][] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        WordSearch w = new WordSearch();

        System.out.println(w.exist(board, "ABCCED"));
        System.out.println(w.exist(board, "SEE"));
        System.out.println(w.exist(board, "ABCB"));

    }

    // Time: O(N * 4^L); where N is the number of cells in the board and L is the length of the word to be matched.
    // Space: O(L); Only call tills we reach the word
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS with backtracking
    // i = index of word
    // x and y represents and row and column cell inside word matrix
    private boolean backtrack(char[][] board, int x, int y, char[] word, int i) {
        // breaking condition: found word
        if (i == word.length) {
            return true;
        }

        //breaking condtionk: out of bound
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        //breaking condtionk: current index do not match the cell
        if (board[x][y] != word[i]) {
            return false;
        }

        // XOR, to mark as visited
        board[x][y] ^= 256;

        boolean exist = backtrack(board, x + 1, y, word, i + 1)
                || backtrack(board, x - 1, y, word, i + 1)
                || backtrack(board, x, y + 1, word, i + 1)
                || backtrack(board, x, y - 1, word, i + 1);

        // XOR, to mark as unvisited
        board[x][y] ^= 256;

        return exist;
    }

}
