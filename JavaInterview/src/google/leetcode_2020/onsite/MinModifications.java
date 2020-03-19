package google.leetcode_2020.onsite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinModifications {

    public static void main(String[] args) {
        char[][] arr = {
                {'R', 'R', 'D'},
                {'L', 'L', 'L'},
                {'U', 'U', 'R'}
        };
        int ans = new MinModifications().findMinimumModifications(arr);
        System.out.println(ans);

        ans = new MinModifications().findMinimumModifications1(arr);
        System.out.println(ans);
    }


    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[] dc = {'D', 'R', 'U', 'L'};

    public int findMinimumModifications(char[][] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int m = arr.length;
        int n = arr[0].length;

        // each block will have minimum steps stored toward reaching bottom most left
        int[][] result = new int[m][n];

        // result and also keeps track of visited
        for (int[] res : result) {
//            Arrays.fill(res, -1);
            Arrays.fill(res, Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            for (int i = 0; i < 4; ++i) {
                int[] dir = directions[i];
                int x = dir[0] + current.x;
                int y = dir[1] + current.y;

                if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
                    continue;
                }
                int modifications = arr[current.x][current.y] == dc[i] ? 0 : 1;
                // if not visited
                if (result[x][y] != Integer.MAX_VALUE) {
                    int cur = result[x][y] + modifications;
                    if (result[x][y] <= cur) {
                        continue;
                    }
                }
                result[x][y] = modifications;
                queue.offer(new Pair(x, y));
            }
        }
        return result[m - 1][n - 1];
    }


    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//    private char[] dc = {'D', 'R', 'U', 'L'};

    private int findMinimumModifications1(char[][] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int m = arr.length;
        int n = arr[0].length;
        int[][] result = new int[m][n];
        for (int[] res : result) {
            Arrays.fill(res, Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int[] d = dir[i];
                int x = d[0] + info[0];
                int y = d[1] + info[1];
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    int temp = arr[info[0]][info[1]] == dc[i] ? 0 : 1;
                    if (result[x][y] != Integer.MAX_VALUE) {
                        int cur = result[x][y] + temp;
                        if (result[x][y] <= cur) continue;
                    }
                    result[x][y] = temp;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return result[m - 1][n - 1];
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

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
