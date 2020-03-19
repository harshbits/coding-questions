package google.leetcode_2020;

import java.util.Arrays;
import java.util.Stack;

public class ValidateStackSequences {

    public static void main(String[] args) {

        int[] pushed = {1, 2, 3, 4, 5}, popped = {4, 5, 3, 2, 1};
        boolean ans = new ValidateStackSequences().validateStackSequences(pushed, popped);

        System.out.println(ans);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed.length != popped.length) {
            return false;
        }

        // o(N) space
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // O(1) space
        // Modifying input pushed array

        int i = 0;
        j = 0;
        for (int x : pushed) {
            pushed[i++] = x;
            while (i > 0 && pushed[i - 1] == popped[j]) {
                --i;
                ++j;
            }
        }
        // return i == 0;

        return stack.isEmpty();
    }
}
