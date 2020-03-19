package google.leetcode_2020.bfs;

import java.util.*;

public class MinimumKnightMoves {

    public static void main(String[] args) {

        int ans = new MinimumKnightMoves().minKnightMoves(2, 1);
        System.out.println(ans);

        ans = new MinimumKnightMoves().minKnightMoves1(2, 1);
        System.out.println(ans);

    }


    private int[][] directions = {{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};

    // Using BFS
    // Around 40% beats
    public int minKnightMoves(int x, int y) {
//        Set<Integer> begin = new HashSet<>();
//        Set<Integer> end = new HashSet<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        int MOD = Math.abs(y) + 2;

//        Set<String> visited = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        // default position is 0,0
//        visited.add("0,0");
        // 0 * MOD + 0 = 0
        visited.add(0);


        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                if (current[0] == x && current[1] == y) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int newX = current[0] + dir[0];
                    int newY = current[1] + dir[1];

//                    if (visited.add(newX + "," + newY) && newX >= -1 && newY >= -1) {
                    if (visited.add(newX * MOD + newY) && newX >= -1 && newY >= -1) {
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    // Using DP
    // Beats 96%
    public int minKnightMoves1(int x, int y) {
        int MOD = Math.abs(y) + 2;
        return dfs(Math.abs(x), Math.abs(y), new HashMap<>(), MOD);
    }

    // DFS
    // DP map is for memoization
    public int dfs(int x, int y, Map<Integer, Integer> dp, int MOD) {
        int index = x * MOD + y;
        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        int ans = 0;
        if (x + y == 0) {
            ans = 0;
        } else if (x + y == 2) {
            ans = 2;
        } else {
            // x-1, y-2
            // x-2, y-1
            // This covers everything as part of Math.abs
            ans = Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2), dp, MOD),
                    dfs(Math.abs(x - 2), Math.abs(y - 1), dp, MOD)) + 1;
        }
        dp.put(index, ans);
        return ans;
    }
}
