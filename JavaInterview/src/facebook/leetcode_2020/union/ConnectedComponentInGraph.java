package facebook.leetcode_2020.union;

//323. Number of Connected Components in an Undirected Graph
public class ConnectedComponentInGraph {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int ans = new ConnectedComponentInGraph().countComponents(n, edges);
        System.out.println(ans);
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.totalDisjointSet;
    }


    // Worst case union and fine time complexity = o(n), all nodes
    // Union By Rank= smaller tree under deeper tree
    // Time complexity O(log n)
    class UnionFind {

        // total nodes
        int n;

        // total disjoint sets
        int totalDisjointSet;

        int[] parent;

        int[] rank;

        public UnionFind(int n) {
            this.n = n;
            this.totalDisjointSet = n;
            this.rank = new int[n];
            this.parent = new int[n];
            // initialize parent
            // initially node itself is a parent
            for (int i = 0; i < n; i++) {
                rank[i] = 0;
                parent[i] = i;
            }
        }

        // Path compression helps find parent in O(1)
        public int find(int x) {
            if (x != parent[x]) {
                // Path compression
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }
            this.totalDisjointSet--;

            int rankX = rank[parentX];
            int rankY = rank[parentY];
            if (rankX >= rankY) {
                int newRank = rankX == rankY ? rankX + rankY : rankX;
                parent[parentY] = parent[parentX];
                rank[parentX] = newRank;
            } else {
                parent[parentX] = parent[parentY];
            }

        }
    }
}
