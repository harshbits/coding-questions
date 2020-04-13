package facebook.leetcode_2020.datastructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = new DailyTemperatures().dailyTemperatures(T);
        System.out.println(Arrays.toString(ans));
    }

    // Time: O(N)
    // Space: O(N)
    public int[] dailyTemperatures(int[] T) {

        int[] daysToWait = new int[T.length];
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i < T.length; i++) {
//            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
//                daysToWait[stack.peek()] = i - stack.pop();
//            }
//            stack.push(i);
//        }

        int[] stack = new int[T.length];
        int top = -1;
        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                daysToWait[stack[top]] = i - stack[top--];
            }
            stack[++top] = i;
        }
        return daysToWait;
    }
}
