package google.leetcode_2020.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FarthestNodeFromEachNode {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] ans = new FarthestNodeFromEachNode().findFarthestLeaf(6, edges);
        System.out.println(Arrays.toString(ans));
    }


    private int N;
    private int[] in;
    private int[] out;
    List<Integer>[] graph;

    // Using Technique In OUT DP
    public int[] findFarthestLeaf(int N, int[][] edges) {
        int[] result = new int[N];
        this.N = N;
        this.in = new int[N];
        this.out = new int[N];
        this.graph = new ArrayList[N];

        // Step 1. Initialize the graph
        // Either list or edge or whatever
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Step 2. Post Order Traversal
        dfsPostOrder(0, -1);
        System.out.println(Arrays.toString(in));

        // Step 3. Pre Order Traversal
        dfsPreOrder(0, -1);

        // Whichever is Max for the result
        for (int i = 0; i < N; i++) {
            result[i] = Math.max(in[i], out[i]);
        }
        return result;
    }


    private void dfsPostOrder(int root, int parent) {
        for (int child : graph[root]) {
            if (child != parent) {
                dfsPostOrder(child, root);
                in[root] = Math.max(in[child], in[child] + 1);
            }
        }
    }

    //The reason we need to select TWO values and not just the best,
    // is as for some particular child, the optimal answer would’ve been present inside its own subtree -
    // therefore we need to consider the second-best value as the optimal in[sibling] value for this specific child.
    private void dfsPreOrder(int root, int parent) {
        int max = -1;
        // second best value
        int secondMax = -1;

        // computation of max and second max
        for (int child : graph[root]) {
            if (child != parent) {
                // second max computation
                if (in[child] > max) {
                    secondMax = max;
                    max = in[child];
                } else if (in[child] > secondMax) {
                    secondMax = in[child];
                }
            }
        }

        for (int child : graph[root]) {
            if (child != parent) {
                // which max to select
                int useMax = in[child] == max ? secondMax : max;
                // parent + 1 = distance to parent is 1
                // or
                // siblings max + 2  = distance to parent is 2
                out[child] = Math.max(1 + out[root], 2 + useMax);
                dfsPreOrder(child, root);
            }
        }
    }
}
