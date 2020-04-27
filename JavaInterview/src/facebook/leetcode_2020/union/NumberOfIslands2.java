package facebook.leetcode_2020.union;

import google.leetcode_2020.disjoint.DisjointSetWithArray;

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

    // up, down, left, right => directions
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> ans = new ArrayList<>();
        if (positions.length == 0) {
            return ans;
        }

        // this will make m * n nodes in the set
        UnionFind uf = new UnionFind(m * n);

        for (int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            int parent = n * row + col;

            // check for duplicate entries
            // for ex: use case
            // {{0, 0}, {0, 1}, {1, 2}, {1, 2}};
            if (uf.isVisited(parent)) {
                ans.add(uf.totalDisjointSet);
                continue;
            }

            uf.setParent(parent);

            // similar to number of islands 1
            // try in all 4 directions
            for (int[] dir : DIRECTIONS) {
                int nr = pos[0] + dir[0];
                int nc = pos[1] + dir[1];
                int newParent = nr * n + nc;
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || uf.parent[newParent] == -1) {
                    continue;
                }
                uf.union(parent, newParent);
            }
            ans.add(uf.totalDisjointSet);
        }
        return ans;
    }

    class UnionFind {
        int n;
        int totalDisjointSet;
        int[] rank;
        int[] parent;

        public UnionFind(int n) {
            this.n = n;
            this.totalDisjointSet = 0;
            this.rank = new int[n];
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                rank[i] = 0;
                parent[i] = -1;
            }
        }

        public void setParent(int x) {
            parent[x] = x;
            totalDisjointSet++;
        }

        // with path compression
        // O(1)
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // O(log n)
        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }

            totalDisjointSet--;

            int rankX = rank[parentX];
            int rankY = rank[parentY];

            if (rankX >= rankY) {
                int newRank = rankX == rankY ? rankX + rankY : rankX;
                rank[parentX] = newRank;
                parent[parentY] = parent[parentX];
            } else {
                parent[parentX] = parent[parentY];
            }
        }

        public boolean isVisited(int x) {
            return parent[x] != -1;
        }
    }
}
