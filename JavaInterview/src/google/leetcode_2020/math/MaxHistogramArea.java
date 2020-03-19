package google.leetcode_2020.math;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * https://www.youtube.com/watch?v=ZmnqCZp9bBs
 * 
 * @author hbhavsar
 *
 */
public class MaxHistogramArea {
	
	public static void main(String[] args) {
		int[] array = { 1, 2, 1, 3, 4, 1 };
		MaxHistogramArea m = new MaxHistogramArea();
		int ans = m.maxHistogram(array);
		System.out.println(ans);
	}
	
	public int maxHistogram(int[] array) {

		if (array == null || array.length == 0) {
			return -1;
		}

		Deque<Integer> stack = new LinkedList<>();
		int maxArea = 0;
		int area = 0;

		int i;
		for (i = 0; i < array.length;) {
			if (stack.isEmpty() || array[stack.peekFirst()] <= array[i]) {
				stack.offerFirst(i++);
			} else {
				int top = stack.pollFirst();
				if (stack.isEmpty()) {
					area = array[top] * i;
				} else {
					area = array[top] * (i - stack.peekFirst() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}

		// After the for loop, if there are elements left in the stack.
		while (!stack.isEmpty()) {
			int top = stack.pollFirst();
			if (stack.isEmpty()) {
				area = array[top] * i;
			} else {
				area = array[top] * (i - stack.peekFirst() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}

		return maxArea;
	}
}
