package facebook.leetcode_2020.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuilding {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        ShortestDistanceFromAllBuilding s = new ShortestDistanceFromAllBuilding();
        int ans = s.shortestDistance(grid);
        System.out.println(ans);
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 0: empty land
    // 1: building
    // 2: obstacle

    // Time: O(m * n) * O(m * n) = O(m^2 * n^2)
    // Space: O(m * n) + O(m * n) = O(m * n)
    public int shortestDistance(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        //count sum of distance from 0 to all building
        int[][] distance = new int[m][n];

        //count how many building each '0' can be reached
        int[][] reach = new int[m][n];

        int buildingNum = 0;

        // Step 1:
        // start from every point 1 (building point),
        // doing BFS traversal to fill out (or accumulate) distance array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 1 means building
                if (grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, i, j, distance, reach);
                }
            }
        }

        // Step 2:
        // find minimum distance
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if empty space and can reachable
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
//        return pair;
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }


    // Time: O(m * n)
    // Space: O(m * n)
    private void bfs(int[][] grid, int x, int y, int[][] distance, int[][] reach) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));

        boolean[][] visited = new boolean[m][n];
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    Pair newPair = new Pair(pair.x + dir[0], pair.y + dir[1]);

                    // boundary and values check
                    // 0 means empty land
                    if (newPair.x < 0 || newPair.x >= m
                            || newPair.y < 0 || newPair.y >= n
                            || visited[newPair.x][newPair.y]
                            || grid[newPair.x][newPair.y] != 0) {
                        continue;
                    }
                    visited[newPair.x][newPair.y] = true;
                    //find next 0: level++;
                    distance[newPair.x][newPair.y] += level;
                    reach[newPair.x][newPair.y]++;
                    queue.offer(newPair);
                }
            }
            level++;
        }
    }

    private class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
