package facebook.leetcode_2020.dfs;

public class IsBipartite {

    public static void main(String[] args) {

    }

    //Time: O (N + E); N = nodes, E = edges
    //Space: O (N + E)

    //Our goal is trying to use two colors to color the graph
    // and see if there are any adjacent nodes having the same color.
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // Initialize a color[] array for each node. Here are three states for colors[] array:
        // 0: Haven't been colored yet.
        // 1: Blue.
        // -1: Red.
        int[] colors = new int[n];

        // for each node if not colored, color it
        for (int i = 0; i < n; i++) {
            // This graph might be a disconnected graph.
            // So check each unvisited node.

            // pass default color as blue
            if (colors[i] == 0 && !dfs(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    //Time: O ( N + E); N = nodes, E = edges
    private boolean dfs(int[][] graph, int[] colors, int color, int node) {
        // Make sure if the color is same,
        // else return false
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int adjacentNode : graph[node]) {
            if (!dfs(graph, colors, -color, adjacentNode)) {
                return false;
            }
        }
        return true;
    }
}
