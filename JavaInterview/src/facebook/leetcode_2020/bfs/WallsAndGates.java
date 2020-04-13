package facebook.leetcode_2020.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    public static void main(String[] args) {
        WallsAndGates w = new WallsAndGates();


        int[][] rooms = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };
        w.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));

        int[][] rooms1 = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };
        w.wallsAndGatesDFS(rooms1);
        System.out.println(Arrays.deepToString(rooms1));
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static final int INF = Integer.MAX_VALUE;

    private static final int GATE = 0;

    // -1 = wall
    // 0 = gate
    // INF = empty room

    // Time: O(m * n)
    // Space: O(m * n)
    public void wallsAndGates(int[][] rooms) {

        if (rooms == null || rooms.length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Pair> queue = new LinkedList<>();

        // Time: O(m * n)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // INF = empty room
                if (rooms[i][j] == GATE) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        // BFS
        // Time: O(m * n)
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                for (int[] dir : DIRECTIONS) {
                    Pair newPair = new Pair(pair.x + dir[0], pair.y + dir[1]);

                    // rooms[i][j] == 0, it's gate
                    if (newPair.x < 0 || newPair.x >= m
                            || newPair.y < 0 || newPair.y >= n
                            || rooms[newPair.x][newPair.y] != INF) {
                        continue;
                    }
                    // Update distance by 1 every level.
                    rooms[newPair.x][newPair.y] = rooms[pair.x][pair.y] + 1;
                    queue.offer(newPair);
                }
            }
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

    // Time: O(m * n)
    public void wallsAndGatesDFS(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int x, int y, int distance) {
        if (x < 0 || x >= rooms.length
                || y < 0 || y >= rooms[0].length
                || rooms[x][y] < distance) {
            return;
        }

        rooms[x][y] = distance;
        for (int[] dir : DIRECTIONS) {
            dfs(rooms, dir[0] + x, dir[1] + y, distance + 1);
        }
    }
}
