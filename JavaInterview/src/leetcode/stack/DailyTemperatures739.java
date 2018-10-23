package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

	public static void main(String[] args) {

		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] ans = new DailyTemperatures739().dailyTemperatures(T);
		System.out.println(Arrays.toString(ans));
	}

	public int[] dailyTemperatures(int[] T) {

		if (T == null || T.length == 0) {
			return new int[0];
		}

		int[] answer = new int[T.length];

		Stack<Integer> stack = new Stack<>(); 
//		for (int i = 0; i < T.length; i++) {
//			while (!stack.isEmpty()) {
//				
//			}			
//		}
		
		// traverse in reverse
		for (int i = T.length - 1; i >= 0; i--) {
			// if the next temperature is not warmer,
			// remove from the stack
			while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();
			}
			
			// if previous temperature is smaller than current,
			// we have our answer
			if (!stack.isEmpty() && T[i] < T[stack.peek()]) {
				// deduct i from the last inserted value,
				// to get the count of the days
				answer[i] = stack.peek() - i;
			}
			// As there are no further elements to compare
			if (stack.isEmpty()) {
				answer[i] = 0;
			}

			// push index, instead of the value
			stack.push(i);
		}

		return answer;
	}
}
