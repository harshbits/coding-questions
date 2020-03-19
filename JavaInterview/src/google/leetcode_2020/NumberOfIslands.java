package google.leetcode_2020;
//
//Example 1:
//
//        Input:
//        11110
//        11010
//        11000
//        00000
//
//Output: 1


//Example 2:
//
//        Input:
//        11000
//        11000
//        00100
//        00011
//
//Output: 3
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int ans = new NumberOfIslands().numIslands(grid);
        System.out.println(ans);
    }


    char zero = '0';
    char one = '1';

    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        if (grid.length == 0) {
            return totalIslands;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == one) {
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

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == zero) {
            return;
        }

        // mark the node value as 0, meaning we wont be visiting that node.
        grid[i][j] = zero;

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
