package facebook.leetcode_2020.datastructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] ans = new NextGreaterElementII().nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));
    }

    // Time: O(N)
    // Space: O(1)
    public int[] nextGreaterElements(int[] nums) {

        int[] stack1 = new int[nums.length];
        int top = -1;
        int n = nums.length;

        int[] ans = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (top > -1 && stack1[top] <= nums[i % n]) {
                top--;
            }
            if (i < n) {
                ans[i] = (top > -1) ? nums[top] : -1;
            }
            stack1[++top] = nums[i % n];

            Deque<Integer> stack = new ArrayDeque<>();
//            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
//                stack.pop();
//            }
//            if (i < n) {
//                ans[i] = stack.isEmpty() ? -1 : stack.peek();
//            }
//            stack.push(nums[i % n]);

//            System.out.println(stack);
//            System.out.println(Arrays.toString(stack1));
        }

        return ans;
    }
}
