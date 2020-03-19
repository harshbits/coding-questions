package google.leetcode_2020;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {

    public static void main(String[] args) {

        int m = 3, n = 3;
//        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {1, 1}};
//        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {1, 2}};
        var ans = new NumberOfIslands2().numIslands2(m, n, positions);
        System.out.println(ans);
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();

        if (positions.length == 0) {
            return ans;
        }

        // up, down, left, right => directions
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // this will make m * n nodes in the set
        DisjointSetWithArray set = new DisjointSetWithArray(m * n);

        for (int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            int parent = n * row + col;

            // check duplicate
            if (!set.isValidParent(parent)) {
                ans.add(set.totalDisjointSet);
                continue;
            }
            set.setParent(parent);

            // similar to number of islands 1
            // try in all 4 directions
            for (int[] dir : dirs) {
                int nr = pos[0] + dir[0];
                int nc = pos[1] + dir[1];
                int newParent = nr * n + nc;
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || set.parent[newParent] == -1) {
                    continue;
                }
                set.union(parent, newParent);
            }
            ans.add(set.totalDisjointSet);
        }
        return ans;
    }
}
