package facebook.leetcode_2020.dp;

import facebook.leetcode_2020.greedy.CampusBikes;

import java.util.Arrays;

public class CampusBike2 {
    public static void main(String[] args) {

        int[][] workers = {{0, 0}, {1, 1}, {2, 0}}, bikes = {{1, 0}, {2, 2}, {2, 1}};

        // bucket sort
        int ans = new CampusBike2().assignBikes1(workers, bikes);
        System.out.println(ans);
    }

    // Time: O(B*W*2^(B))
    public int assignBikes(int[][] workers, int[][] bikes) {

        int m = workers.length;
        int n = bikes.length;

        //dp[i][j]
        //      i represents worker
        //      j represents bikes associated to that worker
        // for example
        // w1 -> 01000101 [bit manipulation represents bikes. 1 = bike]
        int[][] dp = new int[m + 1][1 << n];

        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }

        // initial
        dp[0][0] = 0;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int s = 1; s < (1 << n); s++) {
                for (int j = 0; j < n; j++) {
                    // AND
                    if ((s & (1 << j)) == 0) {
                        continue;
                    }

                    // XOR
                    int prev = s ^ (1 << j);

                    int[] worker = workers[i - 1];
                    int[] bike = workers[j];
                    // Manhattan Distance
                    int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);

                    // Minimum of previous + current distance and existing
                    dp[i][s] = Math.min(dp[i - 1][prev] + dist, dp[i][s]);

                    if (i == m) {
                        min = Math.min(min, dp[i][s]);
                    }
                }
            }
        }

        return min;
    }

    public int assignBikes1(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        int[][] dp = new int[n + 1][1 << m];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s < (1 << m); s++) {
                for (int j = 0; j < m; j++) {
                    if ((s & (1 << j)) == 0) {
                        continue;
                    }
                    int prev = s ^ (1 << j);
                    dp[i][s] = Math.min(dp[i - 1][prev] + dis(workers[i - 1], bikes[j]), dp[i][s]) ;
                    if (i == n) {
                        min = Math.min(min, dp[i][s]);
                    }
                }
            }
        }
        return min;
    }

    public int dis(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
