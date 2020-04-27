package facebook.leetcode_2020.dfs;

public class NumberOfIslands {

    public static void main(String[] args) {
    }

    private static final char ZERO = '0';

    private static final char ONE = '1';

    //Time: O(m * n)
    //Space: O(m * n)
    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        if (grid.length == 0) {
            return totalIslands;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ONE) {
                    totalIslands++;
                    dfsHelper(grid, i, j);
                }
            }
        }
        return totalIslands;
    }

    // This is DFS Helper method
    // It will destroy the island while finding for it.
    private void dfsHelper(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == ZERO) {
            return;
        }

        // mark the node value as 0, meaning we wont be visiting that node.
        grid[i][j] = ZERO;

        // down
        dfsHelper(grid, i + 1, j);

        // up
        dfsHelper(grid, i - 1, j);

        // right
        dfsHelper(grid, i, j + 1);

        // left
        dfsHelper(grid, i, j - 1);
    }
}
