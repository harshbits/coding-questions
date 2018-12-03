package leetcode.uber.sidepractice;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix378 {
	
	public static void main(String[] args) {
		int[][] matrix = { 
				{ 1, 5, 9 }, 
				{ 10, 11, 13 }, 
				{ 12, 13, 15 } };
		int k = 8;
	}
	
	public int kthSmallest(int[][] matrix, int k) {

		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		int count = 0;
		
		while (count < matrix[0].length * matrix.length) {
			int num = minHeap.poll();
			if(count++ == k) {
				
			}
		}
		
		
		return 0;
	}

}
