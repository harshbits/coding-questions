package google.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 * 
 * @author hbhavsar
 *
 */
public class CourseSchedule207 {
	
	public static void main(String[] args) {
		CourseSchedule207 c = new CourseSchedule207();
		int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
		int numCourses = 2;
		boolean ans = c.canFinish(numCourses, prerequisites);
		System.out.println(ans);
		
		ans = c.canFinishDFS(numCourses, prerequisites);
		System.out.println(ans);
	}
	
	
	
	
	
	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		
		boolean[] visited = new boolean[numCourses];
		boolean[] dp = new boolean[numCourses];
		ArrayList<Integer>[] graph = new ArrayList[numCourses];
		
		// initialize all graph edges
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		// add all edges from node
		for (int[] p : prerequisites) {
			graph[p[0]].add(p[1]);
		}
		
		for (int i = 0; i < numCourses; i++) {
			if (!topoUtil(graph, visited, dp, i)) {
				return false;
			}
		}
		return true;
	}
	
	// DFS
	public boolean topoUtil(ArrayList<Integer>[] graph, boolean[] visited, boolean[] dp, int i) {
		if(visited[i]) {
			return dp[i];
//			return true;
		}
		
		visited[i] = true;
		
		for(int p : graph[i]) {
			if (!topoUtil(graph, visited, dp, p)) {
				dp[i] = false;
				return false;
			}
		}

		dp[i] = true;
		return true;
	}
	
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		// represents relation between courses
		int[][] graph = new int[numCourses][numCourses];
		// represents courses we are taking in degree
		int[] inDegree = new int[numCourses];
		

		// for all the edges
		for (int i = 0; i < prerequisites.length; i++) {
			// vertex 0
			int course = prerequisites[i][0];
			// vertex 1
			int prereq = prerequisites[i][1];
			
			if (graph[prereq][course] == 0) {
				// handle duplicate case
				inDegree[course]++;
			}
			// mark edge is visited
			graph[prereq][course] = 1;
		}
		
		// keep total count of courses we tool till now
		int count = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			// all courses which are not visited/covered yet 
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		// BFS
		while (!queue.isEmpty()) {
			// first course from the queue
			int course = queue.poll();
			// increment count for taken courses
			count++;
			
			// for all other courses
			// consider i as prereq
			for (int i = 0; i < numCourses; i++) {
				if (graph[course][i] != 0) {
					if (--inDegree[i] == 0) {
						queue.offer(i);
					}
				}
			}
		}
		
		return count == numCourses;
	}

}
