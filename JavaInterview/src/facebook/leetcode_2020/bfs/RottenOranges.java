package facebook.leetcode_2020.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        // 2 1 1
        // 0 1 1
        // 1 0 1
//        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] grid = {{2, 2, 2, 1, 1}};

        int ans = new RottenOranges().orangesRotting(grid);

        System.out.println(ans);
    }


    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // // Time: O(m * n)
    // Space :  O(m * n)
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int totalFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        // Step 1. Add rotten oranges to queue
        // Time: O(m * n)
        // worst: Space: O(m * n)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    totalFresh++;
                }
            }
        }

        int totalTime = 0;
        // If initial queue is empty then all are good oranges.
        // Time: O(m * n)
        while (!queue.isEmpty() && totalFresh > 0) {
            totalTime++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 2;
                        totalFresh--;
                    }
                }
            }
        }
        return totalFresh == 0 ? totalTime : -1;
    }
}
