package google.leetcode_2020.bfs;

import java.util.*;

public class MinimumFlips {

    public static void main(String[] args) {

        int[][] mat = {{0, 0}, {0, 1}};
//        int[][] mat = {{1, 1, 1}, {1, 0, 1}, {0, 0, 0}};
        int ans = new MinimumFlips().minFlips(mat);
        System.out.println(ans);
//        System.out.println(Arrays.deepToString(mat));
    }


    private int[][] directions = {{0, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minFlips(int[][] mat) {

        int start = 0, m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // OR
                // we could use + operator as well
                // start += mat[i][j] << (i * n + j);
                start |= mat[i][j] << (i * n + j); // convert the matrix to an int.
//                System.out.println(start);
//                System.out.println((start << 1) | mat[i][j]);
            }
        }


        System.out.println(Arrays.deepToString(mat));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // add start to visited.
        Set<Integer> visited = new HashSet<>(queue);

        int steps = 0;
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; sz--) {
                int current = queue.poll();

                // matrix is converted to zero matrix
                if (current == 0) {
                    return steps;
                }

                // traverse all m * n bits of cur.
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        int next = current;
                        // flip the cell (i, j) and its neighbors.

                        // all directions
                        // including current
                        for (int[] dir : directions) {
                            int row = i + dir[0], col = j + dir[1];

                            // Check boundaries
                            if (row >= 0 && row < m && col >= 0 && col < n) {
                                // XOR
                                next ^= 1 << (row * n + col);
                            }
                        }
                        // check if visited.
                        if (visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }


}