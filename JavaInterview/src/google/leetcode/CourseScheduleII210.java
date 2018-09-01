package google.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 * @author hbhavsar
 *
 */
public class CourseScheduleII210 {

	
	public static void main(String[] args) {
		CourseScheduleII210 c = new CourseScheduleII210();
//		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[][] prerequisites = { { 0, 1 }, { 1, 0 } };
		int numCourses = 2;
		int[] ans = c.canFinishDFS1(numCourses, prerequisites);
		System.out.println(Arrays.toString(ans));
	}
	
	
	public int[] canFinishDFS(int numCourses, int[][] prerequisites) {
		
		int[] courseOrder = new int[numCourses];
		boolean[] visited = new boolean[numCourses];
		LinkedList<Integer>[] graph = new LinkedList[numCourses];
		
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new LinkedList<>();
		}
		// add all edges from node
		for (int[] p : prerequisites) {
			graph[p[0]].add(p[1]);
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0 ; i< numCourses; i++) {
			if(!visited[i]) {
				topoSortUtil(graph, visited, stack, i);
			}
		}
		
		if(stack.size() != numCourses) {
			return new int[0];
		}
		
		int in = 0;
		while(!stack.isEmpty()) {
			courseOrder[in++] = stack.pop();
		}
		
		return courseOrder;
		
	}
	
	public void topoSortUtil(LinkedList<Integer>[] graph, boolean[] visited, Stack<Integer> stack, int i) {
		
		visited[i] = true;
		for(int p: graph[i]){
			if(!visited[p]) {
				topoSortUtil(graph, visited, stack, p);
			}
		}
		
		stack.push(i);
	}
	
	
	public int[] canFinishDFS1(int numCourses, int[][] prerequisites) {
		
		int[] courseOrder = new int[numCourses];
		boolean[] visited = new boolean[numCourses];
		boolean[] dp = new boolean[numCourses];
		ArrayList<Integer>[] graph = new ArrayList[numCourses];
		int globalIndex = 0;
		
		// initialize all graph edges
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		// add all edges from node
		for (int[] p : prerequisites) {
			graph[p[0]].add(p[1]);
		}
		
		for (int i = 0; i < numCourses; i++) {
			if (!topoUtil(graph, visited, dp, globalIndex, i, courseOrder)) {
				return new int[0]; // return empty array
			}
		}
		return courseOrder;
	}
	
	// DFS
	public boolean topoUtil(ArrayList<Integer>[] graph, boolean[] visited, boolean[] dp, int globalIndex, int i,
			int[] courseOrder) {
		if(visited[i]) {
			return dp[i];
//			return true;
		}
		
		visited[i] = true;
		
		for(int p : graph[i]) {
			if (!topoUtil(graph, visited, dp, globalIndex, p, courseOrder)) {
				dp[i] = false;
				return false;
			}
		}

		dp[i] = true;
		courseOrder[globalIndex++] = i;
		return true;
	}
	
	// 32 ms 
	// only beats 26% of the results.
	public int[] canFinishBFS(int numCourses, int[][] prerequisites) {
		
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
		int[] ans = new int[numCourses];
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
			ans[count] = course;
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
		
		if(count == numCourses) {
			return ans;	
		}
		return new int[0];
		
	}
	
	
}
