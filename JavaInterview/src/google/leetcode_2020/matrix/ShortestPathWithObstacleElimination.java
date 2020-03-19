package google.leetcode_2020.matrix;

import java.util.*;

public class ShortestPathWithObstacleElimination {

    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0},
        };
        int k = 1;
        int ans = new ShortestPathWithObstacleElimination().shortestPath(grid, k);
        System.out.println(ans);
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {

        // total rows
        int m = grid.length;
        // total columns
        int n = grid[0].length;

        // very smart pruning
        // with sufficiently large k, we can go straight down and right
        if (k >= m + n - 2) {
            return m + n - 2;
        }

        // Visited
        // 0 = not visited
        // 1 = visited
        int[][] visited = new int[m][n];
        for (int[] v : visited) {
            Arrays.fill(v, -1);
        }
//        System.out.println(Arrays.deepToString(visited));
//        boolean[][] visited = new boolean[m][n];
        // BFS
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0, 0, 0});
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, k));

        // ans
        int shortestPath = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
//                int[] current = queue.poll();
                Pair current = queue.poll();

                int currentX = current.x;
                int currentY = current.y;
                int currentK = current.k;

                // smart pruning logic as above
                // Termination logic
                if (currentK >= m + n - 2 - currentX - currentY) {
                    return shortestPath + m + n - 2 - currentX - currentY;
                }
//                // termination condition
//                if (current[0] == m - 1 && current[1] == n - 1) {
//                    return shortestPath;
//                }

                for (int[] dir : directions) {
                    int x = dir[0] + currentX;
                    int y = dir[1] + currentY;

                    if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
                        continue;
                    }

                    int nextK = current.k - grid[x][y];
                    // when nextK > visited[nextX][nextY], it means it is detoured and
                    // have higher chance to reach the destination
                    if (nextK > visited[x][y]) {
                        visited[x][y] = nextK;
                        queue.offer(new Pair(x, y, nextK));
                    }
                }
            }
            shortestPath++;
        }
        return -1;
    }


    class Pair {
        int x;
        int y;
        int k;

        public Pair(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}
