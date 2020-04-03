package facebook.leetcode_2020.dfs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    public static void main(String[] args) {

    }

    public int numDistinctIslands(int[][] grid) {
        // base checks
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<String> distinctPatterns = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    // o = origin
                    dfs(grid, i, j, sb, "o");
                    distinctPatterns.add(sb.toString());
                }
            }
        }
        return distinctPatterns.size();
    }


    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String label) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        // mark visited
        grid[i][j] = 0;
        // append label
        sb.append(label);
        // up
        dfs(grid, i - 1, j, sb, "u");
        // down
        dfs(grid, i + 1, j, sb, "d");
        // left
        dfs(grid, i, j - 1, sb, "l");
        //right
        dfs(grid, i, j + 1, sb, "r");

        // else fail for [
        // [1,1,0],
        // [0,1,1],
        // [0,0,0],
        // [1,1,1],
        // [0,1,0]]
        // no way to know whether its right from curr node or
        // right after backtracking/ after its done from down direction node

        // b = back  (backtracking)
        sb.append("b");
    }
}
