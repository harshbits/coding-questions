package google.leetcode_2020.disjoint;


public class DisjointSetWithArray {

    // count total nodes
    int n;

    // total disjoint sets
    int totalDisjointSet;

    int[] parent;
    int[] rank;


    DisjointSetWithArray(int n) {
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

    public int find(int data) {
        if (data != parent[data]) {
            // path compression
            parent[data] = find(parent[data]);
        }
        return parent[data];
    }

    public void union(int data1, int data2) {

        int parent1 = find(data1);
        int parent2 = find(data2);

        if (parent1 == parent2) {
            return;
        }

        this.totalDisjointSet--;

        int rank1 = rank[parent1];
        int rank2 = rank[parent2];

        if (rank1 >= rank2) {
            int r = rank1 == rank2 ? rank1 + rank2 : rank1;
            parent[parent2] = parent[parent1];
            rank[parent1] = r;

        } else {
            parent[parent1] = parent[parent2];
        }
    }

    // check whether it;s valid parent or not
    public boolean isValidParent(int data) { // for problem 305
        return parent[data] == -1;
    }

}
