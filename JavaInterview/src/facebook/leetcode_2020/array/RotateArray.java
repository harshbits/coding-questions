package facebook.leetcode_2020.array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    // input:
    // 1, 2, 3, 4, 5, 6, 7
    // k = 3
    // output:
    // 5, 6, 7, 1, 2, 3, 4
    public static void rotate(int[] nums, int k) {

        // if k > n.
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        reverse(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));

        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
