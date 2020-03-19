package google.leetcode_2020.dfs;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {
        CourseSchedule2 c = new CourseSchedule2();
        int[][] prerequisites = {{0, 1}, {1, 0}};
        int numCourses = 2;
        int[] ans = c.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(ans));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        LinkedList<Integer>[] graph = new LinkedList[numCourses];

        // initialize all graph edges
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        // add all edges from node
        for (int[] p : prerequisites) {
            graph[p[0]].add(p[1]);
        }

        int[] order = new int[numCourses];
        // declaring as array so we can pass as reference
        int[] globalIndex = new int[1];
        for (int i = 0; i < numCourses; i++) {
            if (!topSortUtil(graph, visited, dp, i, order, globalIndex)) {
                return new int[0];
            }
        }
        return order;
    }

    // dp = already stored answer
    // order = course order
    // globalIndex is for where we are at course order
    private boolean topSortUtil(LinkedList<Integer>[] graph, boolean[] visited, boolean[] dp, int course, int[] order, int[] globalIndex) {
        if (visited[course]) {
            return dp[course];
        }

        // now we have visited course
        visited[course] = true;

        for (Integer edge : graph[course]) {
            if (!topSortUtil(graph, visited, dp, edge, order, globalIndex)) {
                dp[course] = false;
                return false;
            }
        }
        dp[course] = true;
        order[globalIndex[0]++] = course;
        return true;
    }

}

