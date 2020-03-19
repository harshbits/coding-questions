package google.leetcode_2020.onsite;

import java.util.*;

public class SumOfDistancesInTree {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] ans = new SumOfDistancesInTree().sumOfDistancesInTree(6, edges);
        System.out.println(Arrays.toString(ans));

        ans = new SumOfDistancesInTree().sumOfDistancesInTree1(6, edges);
        System.out.println(Arrays.toString(ans));
    }


    // This Beats only 32% of the results
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        // Initialize
        // an array of res, res[i] counts sum of distance in subtree i.
        int[] ans = new int[N];
        // an array count, count[i] counts all nodes in the subtree i.
        int[] count = new int[N];
        // an array visited, visited[i] keeps track of visited nodes.
        boolean[] visited = new boolean[N];
        // tree / graph
        // an array of hashset tree, tree[i] contains all connected nodes to i.
        List<Set<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
//        System.out.println(tree);

        // Post Order DFS traversal
        // Update count and ans array
        // count[root] = sum(count[i]) + 1
        // res[root] = sum(res[i]) + sum(count[i])
        dfsPostOrder(tree, count, ans, 0, visited);
        System.out.println(Arrays.toString(count));

        // Pre Order DFS Traversal
        // When we move our root from parent to its child i,
        // count[i] points get 1 closer to root, n - count[i] nodes get 1 futhur to root.
        // res[i] = res[root] - count[i] + N - count[i]
        Arrays.fill(visited, false);
        dfsPreOrder(tree, count, ans, 0, visited);
        return ans;
    }


    // Time = O(N)
    private void dfsPostOrder(List<Set<Integer>> tree, int[] count, int[] ans, int root, boolean[] visited) {
        visited[root] = true;
        for (int i : tree.get(root)) {
            if (!visited[i]) {
                dfsPostOrder(tree, count, ans, i, visited);
                count[root] += count[i];
                ans[root] += ans[i] + count[i];
            }
        }
        count[root]++;
    }

    // Time = O(N); N = number of nodes
    private void dfsPreOrder(List<Set<Integer>> tree, int[] count, int[] ans, int root, boolean[] visited) {
        visited[root] = true;
        for (int i : tree.get(root)) {
            if (!visited[i]) {
                ans[i] = ans[root] - count[i] + tree.size() - count[i];
                dfsPreOrder(tree, count, ans, i, visited);
            }
        }
    }


    // Using edge custom class.
    private int total = 0;
    private Edge[] edge;
    private int[] head;
    private int[] dp;
    private int[] nodeSum;
    private int[] distanceSum;

    public int[] sumOfDistancesInTree1(int N, int[][] edges) {
        // Maximum
        edge = new Edge[2 * N + 5];
        head = new int[N + 5];
        dp = new int[N + 5];
        nodeSum = new int[N + 5];
        distanceSum = new int[N];
        Arrays.fill(head, -1);

        // add edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            addEdge(u, v);
            addEdge(v, u);
        }

        dfsPostOrder(0, 0);
        distanceSum[0] = dp[0];
        dfsPreOrder(0, 0, N);

        return distanceSum;
    }


    // Time = O(N)
    private void dfsPostOrder(int root, int parent) {
        dp[root] = 0;
        nodeSum[root] = 1;

        for (int i = head[root]; i != -1; i = edge[i].next) {
            int v = edge[i].v;
            if (v != parent) {
                dfsPostOrder(v, root);
                dp[root] += dp[v] + nodeSum[v];
                nodeSum[root] += nodeSum[v];
            }
        }

    }

    // Time = O(N)
    private void dfsPreOrder(int root, int parent, int sum) {
        for (int i = head[root]; i != -1; i = edge[i].next) {
            int v = edge[i].v;
            if (v != parent) {
                distanceSum[v] = distanceSum[root] - nodeSum[v] + sum - nodeSum[v];
                dfsPreOrder(v, root, sum);
            }
        }
    }

    // Add Edge Helper method
    private void addEdge(int u, int v) {
        edge[total] = new Edge(u, v);
        edge[total].next = head[u];
        head[u] = total++;
    }
}


class Edge {
    int u, v, next;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    // we can have getter / setter too, standard java
}