package facebook.leetcode_phone;

public class FriendCircles {

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        int circles = new FriendCircles().findCircleNum1(M);
        System.out.println(circles);

        circles = new FriendCircles().findCircleNum2(M);
        System.out.println(circles);

    }

    // Approach 2. Using DFS

    public int findCircleNum2(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int friendCircles = 0;

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                friendCircles++;
            }
        }
        return friendCircles;
    }

    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (i != j && M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }


    // Approach 1. Using Union Set
    public int findCircleNum1(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            uf.setParent(i);
        }

        for (int i = 0; i < M.length; i++) {
            // This will only scan half of the Matrix
            for (int j = 0; j < i + 1; j++) {
                if (i != j && M[i][j] == 1) {
//                    System.out.println("union: " + i + ", " + j);
                    uf.union(i, j);
                }
            }
        }

        return uf.totalDisjointSet;
    }


    // Disjoint Set Union /  Union Find
    class UnionFind {
        //        int n;
        int[] parent;
        int[] rank;
        int totalDisjointSet;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = -1;
                rank[i] = 0;
            }
            this.totalDisjointSet = 0;
        }

        public void setParent(int data) {
            totalDisjointSet++;
            parent[data] = data;
        }

        public void union(int data1, int data2) {

            // Step 1. Find parents
            int parent1 = find(data1);
            int parent2 = find(data2);

            if (parent1 == parent2) {
                return;
            }

            // merging two data sets
            // so reducing total count
            this.totalDisjointSet--;

            // Step 2. Find Ranks
            int rank1 = rank[parent1];
            int rank2 = rank[parent2];

            if (rank1 >= rank2) {
                // if rank1 is greater than current
                // Keep the same rank
                int newRank = rank1 != rank2 ? rank1 : rank1 + rank2;
                parent[parent2] = parent[parent1];
                rank[parent1] = newRank;
            } else {
                parent[parent1] = parent[parent2];
            }
        }

        public int find(int data) {
            if (data != parent[data]) {
                // path compression
                parent[data] = find(parent[data]);
            }
            return parent[data];
        }
    }

}
